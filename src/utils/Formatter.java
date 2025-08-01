package Utils;

public class Formatter {

    public String formatterString(String name) {

        // Dividi o nome por espaços
        String[] parts = name.trim().toLowerCase().split("\\s+");
        StringBuilder nameFormatted = new StringBuilder();

        for (String parte : parts) {
            if (parte.length() > 0) {

                // Coloquei a primeira letra maiúscula e o restante minúscula
                nameFormatted.append(Character.toUpperCase(parte.charAt(0)))
                        .append(parte.substring(1))
                        .append(" ");
            }
        }

        return nameFormatted.toString().trim(); // Removi o espaço extra no final
    }

}
