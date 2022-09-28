/* Administrador : codigo, correo, nombre, password */
insert into administrador values (01 , "admin1@gmail.com", "Carlos" , "1001");
insert into administrador values (02 , "admin2@gmail.com", "Sandra" , "1002");
insert into administrador values (03 , "admin3@gmail.com", "Patricia" , "1003");

/*Ciudad : codigoPostal, nombre*/
insert into ciudad values ("1","Armenia");
insert into ciudad values ("2","Manizales");
insert into ciudad values ("3","Pereira");
insert into ciudad values ("4","Bogota");
insert into ciudad values ("5","Medellin");
insert into ciudad values ("6","Cali");

/*Teatro : codigo, direccion , nombre, administradorCodigo, ciudadCodigoPostal*/
insert into teatro values ("1","Av Centenario","UniCentenario", 02,"1");
insert into teatro values ("2","Calle 22-Norte ","UniColombia", 02,"4");
insert into teatro values ("3","Av Camellos","UniPelis", 02, "1");
insert into teatro values ("4","Calle 9-Sur","UniTeatro", 02, "3");

/*Administrador Teatro : codigo, correo, nombre, password, teatroCodigo*/
insert into administrador_teatro values (001 , "adminteatro1@gmail.com", "felipe" , "111", "1");
insert into administrador_teatro values (002 , "adminteatro2@gmail.com", "Diego" , "222", "2");
insert into administrador_teatro values (003 , "adminteatro3@gmail.com", "Jose" , "333", "3");

/* Cliente : codigo, correo, nombre, password, estado, foto*/
insert into cliente values (1111,"cliente1@gmail.com","Jhon", "jh", false, "jhon Foto");
insert into cliente values (2222,"cliente2@gmail.com","Camila", "ca", true, "camila Foto");
insert into cliente values (3333,"cliente3@gmail.com","Laura", "la", false, "laura Foto");
insert into cliente values (4444,"cliente4@gmail.com","Peter", "pe", false, "peter Foto");
insert into cliente values (5555,"cliente5@gmail.com","Bety", "be", true, "bety Foto");

/*cliente_telefonos: codigoCliente, telefono*/
insert into cliente_telefonos values (1111, "3210001");
insert into cliente_telefonos values (1111, "3210002");
insert into cliente_telefonos values (1111, "3210003");
insert into cliente_telefonos values (2222, "3140001");
insert into cliente_telefonos values (2222, "3140002");
insert into cliente_telefonos values (3333, "3110001");
insert into cliente_telefonos values (3333, "3110002");
insert into cliente_telefonos values (4444, "3230001");
insert into cliente_telefonos values (5555, "3100004");

/* Confiteria : codigo, categoria, nombre, precio, unidades */
insert into confiteria values (10 , "CRISPETAS", "crispetas grande", 20000, 10);
insert into confiteria values (11 , "CRISPETAS", "crispetas pequena", 12000, 14);
insert into confiteria values (12 , "BEBIDA", "Gaseosa grande", 8000, 11);
insert into confiteria values (13 , "BEBIDA", "Gaseosa pequena", 5000, 10);
insert into confiteria values (14 , "DULCES", "Chocolatina", 2000, 7);
insert into confiteria values (15 , "PAPAS", "Rizadas mayonesa", 6000, 6);

/* Cupon : codigo, descuento, estado, vencimiento, clienteCodigo, */
insert into cupon values (100, 20, false, null, 2222);
insert into cupon values (200, 20, false, null, 3333);
insert into cupon values (300, 20, false, null, 2222);

/*Horario : codigo, anio, dia, hora, mes*/
insert into horario values (1,"2022" , "11" , "7:30" , "10");
insert into horario values (2,"2022" , "11" , "9:30" , "10");
insert into horario values (3,"2022" , "12" , "6:40" , "10");
insert into horario values (4,"2022" , "12" , "8:55" , "10");
insert into horario values (5,"2022" , "13" , "9:00" , "10");

/*Pelicula: Codigo, estado, genero, nombre, reparto, sipnosis, urlimagen, urltrailer*/
insert into pelicula values (90, true, "ACCION", "Thor" ,"Chris Hemsworth","Sipnosis de thor","imagen thor","trailer thor");
insert into pelicula values (91, true, "TERROR", "El conjuro" ,"Los warren","Sipnosis de el conjuro","imagen del conjuro","trailer del conjuro");
insert into pelicula values (92, true, "COMEDIA", "Son como ninos" ,"Adam sandler","Sipnosis de son como ninos","imagen son como ninos","trailer son como ninos");
insert into pelicula values (93, true, "DRAMA", "TITANIC" ,"Leonardo Dicaprio","Sipnosis de titanic","imagen titanic","trailer titanic");

/* Horario_pelicula : codigo, horarioCodigo, peliculaCodigo*/
insert into horario_pelicula values (010, 1, 90);
insert into horario_pelicula values (011, 2, 90);
insert into horario_pelicula values (012, 1, 92);
insert into horario_pelicula values (013, 3, 92);
insert into horario_pelicula values (014, 5, 93);
insert into horario_pelicula values (015, 5, 91);

/* PQRS : codigo, asunto, descripcion, fecha, codigoCliente*/
insert into pqrs values (01,"asusnto del pqrs 1", "descripcion del pqrs 1", null, 1111);
insert into pqrs values (02,"asusnto del pqrs 2", "descripcion del pqrs 2", null, 1111);
insert into pqrs values (03,"asusnto del pqrs 3", "descripcion del pqrs 3", null, 2222);
insert into pqrs values (04,"asusnto del pqrs 4", "descripcion del pqrs 4", null, 3333);
insert into pqrs values (05,"asusnto del pqrs 5", "descripcion del pqrs 5", null, 4444);

/*Calificacion : codigo, puntuacion, clienteCodigo, peliculaCodigo*/
insert into calificacion values (10, 4 , 1111, 91);
insert into calificacion values (20, 3 , 2222, 92);
insert into calificacion values (30, 2 , 4444, 93);
insert into calificacion values (40, 5 , 4444, 93);
insert into calificacion values (50, 4 , 5555, 92);
insert into calificacion values (60, 3 , 1111, 90);

/* Sala : codigo, nombre, codigoPelicula, codigoTeatro*/
insert into sala values ("01", "sala 1", 92 , "1");
insert into sala values ("02", "sala 2", 91 , "1");
insert into sala values ("03", "sala 3", 93 , "1");
insert into sala values ("04", "sala 4", 90 , "1");
insert into sala values ("05", "sala 1", 93 , "2");
insert into sala values ("06", "sala 2", 91 , "2");
insert into sala values ("07", "sala 1", 93 , "3");
insert into sala values ("08", "sala 1", 90 , "4");
insert into sala values ("09", "sala 2", 92 , "4");

/* Silla : numero, columna, fila*/
insert into silla values ("01" , "1" , "A" );
insert into silla values ("02" , "2" , "A" );
insert into silla values ("03" , "3" , "A" );
insert into silla values ("04" , "1" , "B" );
insert into silla values ("05" , "2" , "B" );
insert into silla values ("06" , "3" , "B" );
insert into silla values ("07" , "1" , "C" );
insert into silla values ("08" , "2" , "C" );
insert into silla values ("09" , "3" , "C" );

/*Silla sala : codigo, precio, codigoSala, numeroSilla*/
insert into silla_sala values ("10" , 9900, "01","01");
insert into silla_sala values ("11" , 9900, "01","02");
insert into silla_sala values ("12" , 9900, "01","03");
insert into silla_sala values ("13" , 9900, "01","04");
insert into silla_sala values ("14" , 9900, "01","05");
insert into silla_sala values ("15" , 9900, "01","06");
insert into silla_sala values ("16" , 9900, "01","07");
insert into silla_sala values ("17" , 9900, "01","08");
insert into silla_sala values ("18" , 9900, "01","09");
insert into silla_sala values ("19" , 9900, "08","01");
insert into silla_sala values ("20" , 9900, "08","02");
insert into silla_sala values ("21" , 9900, "08","03");
insert into silla_sala values ("22" , 9900, "08","04");
insert into silla_sala values ("23" , 9900, "08","05");
insert into silla_sala values ("24" , 9900, "08","06");
insert into silla_sala values ("25" , 9900, "08","07");
insert into silla_sala values ("26" , 9900, "08","08");
insert into silla_sala values ("27" , 9900, "08","09");

/*Compra : codigo, fecha, mediopago, clienteCodigo, cuponCodigo, horarioPeliculaCODIGO*/
insert into compra values (00001, null, "CREDITO", 1111, null, 011);
insert into compra values (00002, null, "DEBITO", 2222, null, 012);
insert into compra values (00003, null, "CREDITO", 1111, null, 013);
insert into compra values (00004, null, "CREDITO", 3333, null, 011);
insert into compra values (00005, null, "DEBITO", 4444, null, 010);
insert into compra values (00006, null, "DEBITO", 2222, null, 010);
insert into compra values (00007, null, "CREDITO", 1111, null, 014);
insert into compra values (00008, null, "DEBITO", 2222, null, 014);
insert into compra values (00009, null, "CREDITO", 3333, null, 012);

/* Compra_entrada : compraCodigo, sillaSalaCodigo */
insert into compra_entrada values (00001, "23");
insert into compra_entrada values (00001, "24");
insert into compra_entrada values (00001, "25");






















