import os
from flask import Blueprint, render_template, request, url_for, redirect
from api.services.sqlitecrud_svc import SqliteCrudService
import sqlite3

API_VERSION = os.environ.get('API_VERSION', 'v1')

bp = Blueprint('empleado', __name__, url_prefix=f'/api/{API_VERSION}/empleado')

# Conexión a la base de datos SQLite
def get_db_connection():
    conn = sqlite3.connect('BD.db')  # Reemplaza 'tu_basedatos.db' con el nombre de tu base de datos SQLite
    conn.row_factory = sqlite3.Row
    return conn

@bp.route('/create/', methods=('GET', 'POST'))
def crear_empleado(sqlite_svc: SqliteCrudService):
    if request.method == 'POST':
        nombre = request.form['nombre']
        apellido = request.form['apellido']
        if not nombre:
            print('Nombre no rellenado')
        elif not apellido:
            print('Apellido no rellenado')
        else:
            # Insertar un nuevo empleado en la base de datos
            sql_query = 'INSERT INTO empleado (nombre, apellidos) VALUES (?, ?)'
            params = (nombre, apellido)
            with get_db_connection() as conn:
                conn.execute(sql_query, params)
                conn.commit()
            return redirect(url_for('empleado.listar_empleados'))
    return render_template('crear_empleado.html')

@bp.route('/read', methods=('GET', 'POST'))
def listar_empleados(sqlite_svc: SqliteCrudService):
    rows = []
    if request.method == 'POST':
        nombre = request.form['nombre']
        if not nombre:
            print('No se ha rellenado el nombre')
        else:
            # Buscar empleados por nombre en la base de datos
            sql_query = 'SELECT * FROM empleado WHERE nombre = ?'
            params = (nombre,)
            with get_db_connection() as conn:
                cursor = conn.execute(sql_query, params)
                rows = cursor.fetchall()

    # Si no se ha realizado una búsqueda, listar todos los empleados
    if not rows:
        sql_query = 'SELECT * FROM empleado'
        with get_db_connection() as conn:
            cursor = conn.execute(sql_query)
            rows = cursor.fetchall()

    return render_template('listar_empleados.html', data=rows)

@bp.route('/update/', methods=['POST'])
def actualizar_empleado(service: SqliteCrudService):
    # Recupera los datos de un formulario de actualización
    id_empleado = request.form['id']
    nuevo_nombre = request.form['nuevo_nombre']
    nuevo_apellido = request.form['nuevo_apellido']

    # Actualiza los datos del empleado en la base de datos
    sql_query = 'UPDATE empleado SET nombre = ?, apellidos = ? WHERE id = ?'
    params = (nuevo_nombre, nuevo_apellido, id_empleado)
    with get_db_connection() as conn:
        conn.execute(sql_query, params)
        conn.commit()

    return redirect(url_for('empleado.listar_empleados'))

@bp.route('/delete/', methods=['POST'])
def eliminar_empleado(service: SqliteCrudService):
    # Recupera el ID del empleado a eliminar desde el formulario
    id_empleado = request.form['id']

    # Elimina el empleado de la base de datos
    sql_query = 'DELETE FROM empleado WHERE id = ?'
    params = (id_empleado,)
    with get_db_connection() as conn:
        conn.execute(sql_query, params)
        conn.commit()

    return redirect(url_for('empleado.listar_empleados'))
