import java.util.Scanner;

public class DNAStorage {

    // Convert text to binary
    public static String textToBinary(String text) {
        StringBuilder binary = new StringBuilder();
        for (char ch : text.toCharArray()) {
            binary.append(String.format("%8s",
                    Integer.toBinaryString(ch)).replace(' ', '0'));
        }
        return binary.toString();
    }

    // Convert binary to DNA (00=A, 01=C, 10=G, 11=T)
    public static String binaryToDNA(String binary) {
        StringBuilder dna = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 2) {
            String pair = binary.substring(i, i + 2);
            switch (pair) {
                case "00": dna.append("A"); break;
                case "01": dna.append("C"); break;
                case "10": dna.append("G"); break;
                case "11": dna.append("T"); break;
            }
        }
        return dna.toString();
    }

    // Convert DNA back to binary
    public static String dnaToBinary(String dna) {
        StringBuilder binary = new StringBuilder();
        for (char base : dna.toCharArray()) {
            switch (base) {
                case 'A': binary.append("00"); break;
                case 'C': binary.append("01"); break;
                case 'G': binary.append("10"); break;
                case 'T': binary.append("11"); break;
            }
        }
        return binary.toString();
    }

    // Convert binary back to text
    public static String binaryToText(String binary) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            String byteStr = binary.substring(i, i + 8);
            int charCode = Integer.parseInt(byteStr, 2);
            text.append((char) charCode);
        }
        return text.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== DNA Data Storage Simulator =====");
        System.out.print("Enter text to store in DNA: ");
        String inputText = scanner.nextLine();

        // Encoding
        String binary = textToBinary(inputText);
        String dna = binaryToDNA(binary);

        System.out.println("\nBinary Representation:");
        System.out.println(binary);

        System.out.println("\nDNA Sequence:");
        System.out.println(dna);

        // Decoding
        String retrievedBinary = dnaToBinary(dna);
        String retrievedText = binaryToText(retrievedBinary);

        System.out.println("\nRetrieved Text After Decoding:");
        System.out.println(retrievedText);

        if (inputText.equals(retrievedText)) {
            System.out.println("\nData Integrity Verified ✅");
        } else {
            System.out.println("\nData Corrupted ❌");
        }

        scanner.close();
    }
}
