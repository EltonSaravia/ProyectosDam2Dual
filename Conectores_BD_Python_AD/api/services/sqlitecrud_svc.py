"""api/services/sqlitecrud_svc.py"""
import os
from sqlite3 import DatabaseError, connect
from injector import inject


DATABASE_NAME = os.environ['DB_NAME']


class SqliteCrudService:
    """Servicio CRUD para cliente sqlite"""
    @inject
    def __init__(self):
        # create connection
        self.connection = connect(DATABASE_NAME)
        self.cursor = self.connection.cursor()
        print("Conexion SQLite iniciada")

    # TODO: Implementar metodo INSERT (utilizar el cursor y la conexión definidas arriba)
    def create(self, sql_query, params) -> str:
        """Crea un nuevo registro con los parámetros y devuelve el resultado. """
        # Ejemplo de query: ''' INSERT INTO tabla(campo1,campo2,campo3) VALUES(?,?,?) '''       
        try:
            # COMPLETAR CODIGO
            pass
        except DatabaseError as ex:
            print("SQLite create query exception: %", str(ex))
        return ''

    # TODO: Implementar metodo READ (utilizar el cursor y la conexión definidas arriba)
    def read(self, sql_query, params):
        """Devuelve en una lista el resultado de la query"""
        # Cada fila es como una tupla con un entero como indice
        # Ejemplo de query:  "SELECT * FROM `tabla`
        try:
            # COMPLETAR CODIGO
            pass
        except DatabaseError as ex:
            print("SQLite read query exception: %", str(ex))

    # TODO: Implementar metodo UPDATE (utilizar el cursor y la conexión definidas arriba)
    def update(self, sql_query):
        """Actualiza un elemento"""
        try:
            # COMPLETAR CODIGO
            pass
        except DatabaseError as ex:
            print("SQLite read query exception: %", str(ex))

    # TODO: Implementar metodo DELETE (utilizar el cursor y la conexión definidas arriba)
    def delete(self):
        """Elimina un elemento"""
        try:
            # COMPLETAR CODIGO
            pass
        except DatabaseError as ex:
            print("SQLite read query exception: %", str(ex))

    # close cursor and connection
    def dispose(self):
        """Cierre de conexion con la BD"""
        self.cursor.close()
        self.connection.close()
