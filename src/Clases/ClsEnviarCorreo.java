/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Entidades.ClsClave;
import Funcionalidades.ClsOperaClave;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Authenticator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Freak
 */
public class ClsEnviarCorreo {
    static String p1,p11;
    static String p2,p22;
    static String p3,p33;
    static String p4,p44;
    static String p5,p55;
    static String CorreoServidor,ContraseñaServidor;
    public ClsEnviarCorreo(){
        List<ClsClave> Parametros = (new ClsOperaClave()).ConsultaLista("1000", "", "");
        if (!Parametros.isEmpty()){
            p1 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 1).collect(Collectors.toList()).get(0).NombreDeClave();
            p11 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 1).collect(Collectors.toList()).get(0).Descripcion();
            p2 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 2).collect(Collectors.toList()).get(0).NombreDeClave();
            p22 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 2).collect(Collectors.toList()).get(0).Descripcion();
            p3 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 3).collect(Collectors.toList()).get(0).NombreDeClave();
            p33 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 3).collect(Collectors.toList()).get(0).Descripcion();
            p4 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 4).collect(Collectors.toList()).get(0).NombreDeClave();
            p44 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 4).collect(Collectors.toList()).get(0).Descripcion();
            p5 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 5).collect(Collectors.toList()).get(0).NombreDeClave();
            p55 = Parametros.stream().filter(u -> u.SecuencialDeClave() == 5).collect(Collectors.toList()).get(0).Descripcion();
            CorreoServidor = Parametros.stream().filter(u -> u.SecuencialDeClave() == 6).collect(Collectors.toList()).get(0).NombreDeClave();
            ContraseñaServidor = Parametros.stream().filter(u -> u.SecuencialDeClave() == 7).collect(Collectors.toList()).get(0).NombreDeClave();
        }
    }
    public void ConfiguracionPrueba(String Correo, String Contraseña, String Puerto,String Host){
        CorreoServidor = Correo;
        ContraseñaServidor = Contraseña;
        p3 = Host;
        p5 = Puerto;
    }
    public static boolean EnviarCorreo(String To, String Asunto, String Titulo, String SubTitulo, String Mensaje,String Ruta){
        Properties parametro = new Properties();
        parametro.put(p11,p1);
        parametro.put(p22,p2);
        parametro.put(p33,p3);
        parametro.put(p44,p4);
        parametro.put(p55,p5);
        Session session = Session.getInstance(parametro,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(CorreoServidor, ContraseñaServidor);
                    }
                });
        session.setDebug(true);
        try{
            BodyPart text = new MimeBodyPart();
            String Contenido = Contenido(Ruta);
            Contenido = Contenido.replace("#Titulo#", Titulo);
            Contenido = Contenido.replace("#SubTitulo#", SubTitulo);
            Contenido = Contenido.replace("#Mensaje#", Mensaje);
            Contenido = Contenido.replace("#Version#", ClsControlVersion.Version());
            System.out.println(Contenido);
            text.setContent(Contenido,"text/html");
            MimeMultipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(text);
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(CorreoServidor));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(To));
            message.setSubject(Asunto);
            message.setContent(multiPart);
            
            Transport.send(message);
        }catch(MessagingException e){
            return false;
        }
        return true;
    }
    public static String Contenido(String Archivo){
        try{
            String Cadena,HTML="";
            FileReader FR = new FileReader(Archivo);
            BufferedReader BR = new BufferedReader(FR);
            while((Cadena = BR.readLine())!=null) {
                HTML += Cadena;
            }
            BR.close();
            return HTML;
        }catch(FileNotFoundException ex){
            Logger.getLogger(ClsEnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClsEnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
