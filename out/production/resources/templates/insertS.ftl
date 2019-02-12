<!DOCTYPE html>
<html>

<head>
    <title style="float: center; ">Insertar Estudiante</title>
</head>

<body style="background-color: beige;">
<header >
    <h1 style="float: center; font-family: Arial;">Insertar estudiante</h1>
</header>

<nav >
    <div >
        <div >
            <ul style="list-style-type: none; margin: 0; padding: 0; overflow: hidden; background-color: #333;">
                <li style="float: left; font-family: Arial;">
                    <a  href="/" style="display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;">Inicio</a>
                </li>
                <li style="float: left; font-family: Arial;">
                    <a  href="/insert" style="display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;">Agregar</a>
                </li>
                <li style="float: left; font-family: Arial;">
                    <a  href="/update/0" style="display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;">Modificar</a>
                </li>
                <li style="float: left; font-family: Arial;">
                    <a  href="/listdelete/0" style="display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;">Eliminar</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div >


    <hr>
    <form method="post" action="/listinsert">

        <div >
            <label for="matricula">Matricula</label>
            <input type="text" id="matricula" name="matricula" placeholder="Matricula" required>
        </div>

        <div>
            <label for="nombre">Nombre</label>
            <input type="text"id="nombre" name="nombre" placeholder="Nombre" required>
        </div>

        <div>
            <label for="apellido">Apellido</label>
            <input type="text"  id="apellido" name="apellido" placeholder="Apellido" required>
        </div>

        <div >
            <label for="telefono">Teléfono</label>
            <input type="text"  id="telefono" name="telefono" placeholder="Telefono" required>
        </div>

        <input type="submit" value="Insertar estudiante a la tabla">

    </form>
</div>

</body>

</html>