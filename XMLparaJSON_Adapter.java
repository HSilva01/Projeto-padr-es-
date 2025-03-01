
import java.util.HashMap;
import java.util.Map;

public class XMLparaJSON_Adapter {

    public String convertXMLToJSON(String xml) {
        String json = "{";
        
        // Remover a declaração XML
        xml = xml.replace("<?xml version=\"1.0\"?>", "");

        // Manipular o XML manualmente
        xml = xml.replaceAll("<data>", "")
                 .replaceAll("</data>", "")
                 .trim();

        String[] entries = xml.split("</student>");
        for (String entry : entries) {
            if (!entry.trim().isEmpty()) {
                json += "\"student\": {";
                String[] fields = entry.split(">");
                for (String field : fields) {
                    if (field.contains("<")) {
                        String[] keyValue = field.split("<");
                        String key = keyValue[1].trim();
                        String value = keyValue[0].trim();
                        json += "\"" + key + "\": \"" + value + "\",";
                    }
                }
                // Remover a última vírgula
                json = json.substring(0, json.length() - 1);
                json += "},";
            }
        }
        // Remover a última vírgula e fechar o JSON
        json = json.substring(0, json.length() - 1) + "}";
        
        return json;
    }
}
