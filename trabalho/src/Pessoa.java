public abstract class Pessoa {
    protected String nome, estadoCivil, dataNascimento;
    protected String cpf;
    protected Endereco end;


public static boolean validaCPF(String cpf) {
    cpf = cpf.replaceAll("[^0-9]", ""); //substitui todos os caracters que não são numeros como um espaço vazio

    if (cpf.length() != 11) {
        return false;
    }

    if (cpf.matches("(\\d)\\1{10}")) { //verifica se todos os digitos são iguais, caso positivo, retorna falso
        return false;
    }

    int sum = 0;
    for (int i = 0; i < 9; i++) {
        sum += (cpf.charAt(i) - '0') * (10 - i);
    }
    int remainder = sum % 11;
    int firstDigit = (remainder < 2) ? 0 : (11 - remainder);

    if ((cpf.charAt(9) - '0') != firstDigit) {
        return false;
    }

    sum = 0;
    for (int i = 0; i < 10; i++) {
        sum += (cpf.charAt(i) - '0') * (11 - i);
    }
    remainder = sum % 11;
    int secondDigit = (remainder < 2) ? 0 : (11 - remainder);

    if ((cpf.charAt(10) - '0') != secondDigit) {
        return false;
    }

    return true;
}

}
