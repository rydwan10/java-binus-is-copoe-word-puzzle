import java.util.ArrayList;
import java.util.Arrays;

public class WordList {
    private ArrayList<String> levelOneAnswers = new ArrayList<>(
            Arrays.asList(
                    "die",
                    "led",
                    "edit",
                    "idle",
                    "tilted",
                    "titled",
                    "lei",
                    "lied",
                    "let",
                    "tide",
                    "lid",
                    "tied",
                    "lie",
                    "tile",
                    "lit",
                    "tilt",
                    "tie",
                    "tilde",
                    "deli",
                    "tiled",
                    "diet",
                    "title")
    );
    private ArrayList<String> levelTwoAnswers = new ArrayList<>(
            Arrays.asList(
                    "encase",
                    "seance",
                    "seneca",
                    "acnes",
                    "canes",
                    "cease",
                    "cense",
                    "scena",
                    "scene",
                    "aces",
                    "acne",
                    "cane",
                    "cans",
                    "case",
                    "cees",
                    "scan",
                    "ace",
                    "can",
                    "cee",
                    "sac",
                    "sec",
                    "anes",
                    "ease",
                    "esne",
                    "naes",
                    "sane",
                    "seen",
                    "sene",
                    "ane",
                    "ens",
                    "nae",
                    "nee",
                    "sae",
                    "san",
                    "sea",
                    "see",
                    "sen"
            )
    );
    private ArrayList<String> levelThreeAnswers = new ArrayList<>(
            Arrays.asList(
                    "honker",
                    "hoke",
                    "honk",
                    "hork",
                    "okeh",
                    "krone",
                    "heron",
                    "honer",
                    "keno",
                    "kern",
                    "kore",
                    "hern",
                    "hero",
                    "hoer",
                    "hone",
                    "horn",
                    "ken",
                    "kor",
                    "oke",
                    "hen",
                    "her",
                    "hoe",
                    "hon",
                    "noh",
                    "rho",
                    "reno",
                    "eon",
                    "ern",
                    "nor",
                    "one",
                    "ore",
                    "roe"
            )
    );

    public ArrayList<String> getLevelOneAnswers() {
        return levelOneAnswers;
    }

    public ArrayList<String> getLevelTwoAnswers() {
        return levelTwoAnswers;
    }

    public ArrayList<String> getLevelThreeAnswers() {
        return levelThreeAnswers;
    }

}
