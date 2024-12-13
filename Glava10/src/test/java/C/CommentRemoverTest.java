package C;
import C.CommentRemover;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;
//Романов Альберт Б762-2 Вариант 9
public class CommentRemoverTest {

    @Test
    public void testRemoveComments() throws IOException {
        String inputCode = "public class Test { // коментарий\n /* \n комментарий */ int x = 10; }";
        String expectedOutput = "public class Test { \n  int x = 10; }";

        String result = CommentRemover.removeComments(inputCode);
        assertEquals(expectedOutput, result);
    }
}

