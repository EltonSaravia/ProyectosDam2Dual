from injector import noscope
from api.services.sqlitecrud_svc import SqliteCrudService

def configure(binder):
    binder.bind(SqliteCrudService, to=SqliteCrudService, scope=noscope)
