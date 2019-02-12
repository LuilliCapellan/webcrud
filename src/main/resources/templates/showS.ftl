<!DOCTYPE html>
<html >

<head>

    <title>Check Estudiante</title>

</head>

<body style="background-color: #FFFFFF;">

<header >
    <h1 style="float: center; font-family: Arial;">Check estudiante</h1>
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
    <div >
        <div >
            <ul >
                <li style="font-family: Arial"><span > <strong> Matricula:</strong> </span>${actual.matricula?c}</li>
                <li style="font-family: Arial"><span > <strong> Nombre: </strong> </span>${actual.nombre}</li>
                <li style="font-family: Arial"><span > <strong> Apellido:</strong> </span>${actual.apellido}</li>
                <li style="font-family: Arial"><span > <strong> Telefono: </strong></span>${actual.telefono}</li>
            </ul>
        </div>
    </div>
</div>


</body>

</html>