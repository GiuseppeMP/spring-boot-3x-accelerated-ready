package twlabsbrazil.handson.genai.model;

import twlabsbrazil.handson.genai.shared.ValueObject;

public class Cpf implements ValueObject<String> {

    String value;

    private Cpf(String value) {
        this.value = value;
    }

    static Cpf create(String value) {
        if (!Cpf.isValid(value))
            throw new IllegalArgumentException("Cpf value is invalid: " + value);
        return new Cpf(value);

    }

    /**
     * @param cpf
     * @return boolean
     */
    static private boolean isValid(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // Remove everything except digits
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444")
                || cpf.equals("55555555555") || cpf.equals("66666666666")
                || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999") || (cpf.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                return (true);
            else
                return (false);
        } catch (Exception erro) {
            return (false);
        }
    }

    @Override
    public boolean sameValueAs(String other) {
        return this.value == null ? other == null : this.value.equals(other);
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public static boolean validarCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i);
        }

        int firstDigit = sum % 11 < 2 ? 0 : 11 - (sum % 11);
        if (firstDigit == 10) {
            firstDigit = 0;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * (11 - i);
        }

        int secondDigit = sum % 11 < 2 ? 0 : 11 - (sum % 11);
        if (secondDigit == 10) {
            secondDigit = 0;
        }

        return firstDigit == digits[9] && secondDigit == digits[10];
    }

}
