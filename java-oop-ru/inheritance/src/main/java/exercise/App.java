package exercise;

import java.util.Map;
import java.util.List;

public class App {
    public static void main(String[] args) {

//        Map<String, String> map = Map.of("class", "v-10", "id", "wop");
//        Tag tag = new SingleTag("img", map);
//        System.out.println(tag.toString());

        Tag div = new PairedTag(
                "div",
                Map.of("class", "y-5"),
                "tag body",
                List.of(
                        new SingleTag("br", Map.of("id", "s")),
                        new SingleTag("hr", Map.of("class", "a-5"))
                )
        );
        System.out.println(div.toString());
        //<div class="y-5"><br id="s"><hr class="a-5"></div>
    }
}