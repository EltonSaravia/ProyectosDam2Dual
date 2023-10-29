import os
from sqlite3 import DatabaseError, connect
from injector import inject

DATABASE_NAME = os.environ['DB_NAME']

class SqliteCrudService:
    """Servicio CRUD para cliente sqlite"""
    @inject
    def __init__(self):
        # Crear conexión a la base de datos
        self.connection = connect(DATABASE_NAME)
        self.cursor = self.connection.cursor()
        print("Conexión SQLite iniciada")

    def create(self, sql_query, params) -> str:
        """Crea un nuevo registro con los parámetros y devuelve el resultado."""
        try:
            self.cursor.execute(sql_query, params)
            self.connection.commit()
            return 'Registro creado exitosamente'
        except DatabaseError as ex:
            print("Excepción en la consulta de creación SQLite: %s" % str(ex))
            return 'Error al crear el registro'

    def read(self, sql_query, params):
        """Devuelve en una lista el resultado de la consulta"""
        try:
            self.cursor.execute(sql_query, params)
            rows = self.cursor.fetchall()
            return rows
        except DatabaseError as ex:
            print("Excepción en la consulta de lectura SQLite: %s" % str(ex))
            return []

    def update(self, sql_query, params):
        """Actualiza un elemento"""
        try:
            self.cursor.execute(sql_query, params)
            self.connection.commit()
            return 'Registro actualizado exitosamente'
        except DatabaseError as ex:
            print("Excepción en la consulta de actualización SQLite: %s" % str(ex))
            return 'Error al actualizar el registro'

    def delete(self, sql_query, params):
        """Elimina un elemento"""
        try:
            self.cursor.execute(sql_query, params)
            self.connection.commit()
            return 'Registro eliminado exitosamente'
        except DatabaseError as ex:
            print("Excepción en la consulta de eliminación SQLite: %s" % str(ex))
            return 'Error al eliminar el registro'

    def dispose(self):
        """Cierre de conexión con la BD"""
        self.cursor.close()
        self.connection.close()
