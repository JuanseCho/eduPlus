package com.eduPlus.controller;

import ch.qos.logback.classic.Logger;
import com.eduPlus.Modelo.Rol;
import com.eduPlus.Modelo.Usuario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LeerExcel {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LeerExcel.class);

    public static List<Usuario> obtenerUsuariosDeArchivo(File file) {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Variable para rastrear el número de fila
            int rowCount = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (rowCount == 0) {
                    rowCount++;
                    continue;
                }

                Iterator<Cell> cellIterator = row.cellIterator();
                Usuario usuario = new Usuario(); // Crear una instancia de Usuario para cada fila

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0: // Tipo de documento
                            String tipoDocumentoStr = cell.getStringCellValue();
                            usuario.setTipoDocumento(Usuario.TipoDocumento.valueOf(tipoDocumentoStr));
                            break;
                        case 1: // Documento
                            usuario.setDocumento(String.valueOf((int) cell.getNumericCellValue()));
                            usuario.setPassword(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                        case 2: // Apellidos
                            usuario.setApellidos(cell.getStringCellValue());
                            break;
                        case 3: // Nombres
                            usuario.setNombres(cell.getStringCellValue());
                            break;
                        case 4: // Especialidad
                            usuario.setEspecialidad(cell.getStringCellValue());
                            break;
                        case 5: // Email
                            usuario.setEmail(cell.getStringCellValue());
                            break;
                        case 6: // Celular
                            usuario.setCelular(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                        case 7: // Dirección
                            usuario.setDireccion(cell.getStringCellValue());
                            break;
                        case 8: // Estado
                            String estadoStr = cell.getStringCellValue();
                            usuario.setEstado(Usuario.Estado.valueOf(estadoStr));
                            break;
                        case 9: // Rol
                            String rolStr = cell.getStringCellValue();
                            switch (rolStr) {
                                case "DOCENTE":
                                    usuario.setIdRol(new Rol(2, rolStr));
                                    break;
                                case "ESTUDIANTE":
                                    usuario.setIdRol(new Rol(3, rolStr));
                                    break;
                                case "RECTOR":
                                    usuario.setIdRol(new Rol(4, rolStr));
                                    break;
                                case "SECRETARIA":
                                    usuario.setIdRol(new Rol(5, rolStr));
                                    break;
                                case "COORDINADOR":
                                    usuario.setIdRol(new Rol(6, rolStr));
                                    break;
                                case "ACUDIENTE":
                                    usuario.setIdRol(new Rol(7, rolStr));
                                    break;
                                default:
                                    LOGGER.error("No se encontró el rol con id {}", rolStr);
                                    break;
                            }
                            break;
                        // Agregar más casos según sea necesario para otros campos del usuario
                    }
                }
                usuarios.add(usuario); // Agregar el usuario a la lista
                rowCount++;
            }
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuarios;
    }



}
