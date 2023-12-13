
# api/controllers/home/_controller.py
import os
from flask import Blueprint, render_template


API_VERSION = os.environ.get('API_VERSION', 'v1')
textos = [{'titulo': 'BD Embebidas',
           'contenido': 'Crear un sistema de persistencia de datos con distintas BD embebidas'}
          ]

bp = Blueprint('home', __name__, url_prefix=f'/api/{API_VERSION}/home')


@bp.route('/')
def index():
    """Pagina principal"""
    return render_template('index.html', textos=textos)