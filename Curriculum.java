
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Curriculum {

  public static void main(String[] args) {
    String texto = readFile();
    String nombre = texto.substring(texto.indexOf(">>>nombre") + 9, texto.indexOf(">>>telefono")).trim();
    String telefono = texto.substring(texto.indexOf(">>>telefono") + 11, texto.indexOf(">>>email")).trim();
    String email = texto.substring(texto.indexOf(">>>email") + 8, texto.indexOf(">>>intereses")).trim();
    String[] intereses = texto.substring(texto.indexOf(">>>intereses") + 12, texto.indexOf(">>>habilidades")).trim().split("\n");
    String[] habilidades = texto.substring(texto.indexOf(">>>habilidades") + 14, texto.indexOf(">>>estudios")).trim().split("\n");
    String[] estudios = texto.substring(texto.indexOf(">>>estudios") + 11, texto.indexOf(">>>experiencia")).trim().split("\n");
    String[] experiencia = texto.substring(texto.indexOf(">>>experiencia") + 14, texto.indexOf(">>>yo")).trim().split("\n");
    String[] sobreMi = texto.substring(texto.indexOf(">>>yo") + 5).trim().split("\n");

    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter("curriculum.html"));
      bw.write("<!DOCTYPE html>\n"
              + "<html lang=\"en\">\n"
              + "<head>\n"
              + "    <meta charset=\"UTF-8\">\n"
              + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
              + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
              + "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n"
              + "    <title>Mi curriculum</title>\n"
              + "</head>\n"
              + "<body class=\"bg-dark\">\n"
              + "<div class=\"container text-center text-white\">\n"
              + "  <br><br>\n"
              + "  <u><h1 class=\"font-weight-bold\">Curriculum Vitae</h1></u>\n"
              + "  <h4 class=\"font-weight-bold\">" + nombre + "</h4>\n"
              + "  <h4 class=\"font-weight-bold\">" + telefono + "</h4>"
              + "  <h4 class=\"font-weight-bold\">" + email + "</h4>"
              + "  </div>\n"
              + "  <br>\n"
              + "<div id=\"jumbotron\" class=\"jumbotron text-white bg-secondary\">\n"
              + "<div id=\"intereses\" class=\"text-center\">\n"
              + "  <p class=\"font-weight-bold text-success\">Mis intereses</p>\n"
              + "  <ul>\n");
      for (String interes : intereses) {
        bw.write("<li>" + interes + "</li>");
      }

      bw.write("</div>"
              + "</ul>\n"
              + "<div id=\"habilidades\" class=\"text-center\">\n"
              + "  <p class=\"font-weight-bold text-success\">Mis habilidades</p>\n"
              + "  <ul>");

      for (String habilidad : habilidades) {
        bw.write("<li>" + habilidad + "</li>");
      }

      bw.write("</div>"
              + "</ul>\n"
              + "<div id=\"estudios\" class=\"text-center\">\n"
              + "  <p class=\"font-weight-bold text-success\">Mis estudios</p>\n"
              + "  <ul>");

      for (String estudio : estudios) {
        bw.write("<li>" + estudio + "</li>");
      }
      bw.write("</div>"
              + "</ul>\n"
              + "<div id=\"experiencia\" class=\"text-center\">\n"
              + "  <p class=\"font-weight-bold text-success\">Mi experiencia laboral</p>\n"
              + "  <ul>");
      for (String exp : experiencia) {
        bw.write("<li>" + exp + "</li>");
      }

      bw.write("</div>"
              + "</ul>\n"
              + "<div id=\"sobreMi\" class=\"text-center\">\n"
              + "  <p class=\"font-weight-bold text-success\">Sobre mí</p>\n"
              + "  <ul>");
      for (String sobre : sobreMi) {
        bw.write("<li>" + sobre + "</li>");
      }
      bw.write("</div>"
              + "</div>\n"
              + "</body>\n"
              + "</html>");

      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static String readFile() {
    String texto = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader("infoCurriculum.txt"));
      String linea = "";
      while ((linea = br.readLine()) != null) {
        texto += linea + "\n";

      }
      br.close();

    } catch (FileNotFoundException e) {
      System.out.println("infoCurriculum.txt no se pudo encontrar");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return texto;
  }

}
