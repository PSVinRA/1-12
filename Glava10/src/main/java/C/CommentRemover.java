package C;
import java.io.*;
import java.util.regex.Pattern;
//Романов Альберт Б762-2 Вариант 9
public class CommentRemover {

    private static final Pattern COMMENT_PATTERN = Pattern.compile("(\\/\\/.*?$|\\/\\*.*?\\*\\/)", Pattern.DOTALL | Pattern.MULTILINE);

    public static String removeComments(String sourceCode) {
        return COMMENT_PATTERN.matcher(sourceCode).replaceAll("");
    }

    public static void processFile(String inputPath, String outputPath) throws IOException {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }

        String sourceCode = new String(java.nio.file.Files.readAllBytes(inputFile.toPath()));
        String result = removeComments(sourceCode);

        java.nio.file.Files.writeString(outputFile.toPath(), result);
    }
}

