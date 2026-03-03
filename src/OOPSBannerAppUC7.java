public class OOPSBannerAppUC7 {

    static class CharacterPatternMap {

        private Character character;
        private String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {

        String[] O = {
                " ***  ",
                "*   * ",
                "*   * ",
                "*   * ",
                "*   * ",
                "*   * ",
                " ***  "
        };

        String[] P = {
                "****  ",
                "*   * ",
                "*   * ",
                "****  ",
                "*     ",
                "*     ",
                "*     "
        };

        String[] S = {
                " *****",
                "*     ",
                "*     ",
                " *****",
                "     *",
                "     *",
                " *****"
        };

        String[] space = {
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       "
        };

        CharacterPatternMap[] charMaps = new CharacterPatternMap[4];

        charMaps[0] = new CharacterPatternMap('O', O);
        charMaps[1] = new CharacterPatternMap('P', P);
        charMaps[2] = new CharacterPatternMap('S', S);
        charMaps[3] = new CharacterPatternMap(' ', space);

        return charMaps;
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {

        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }

        return getCharacterPattern(' ', charMaps);
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {

        for (int i = 0; i < 7; i++) {

            StringBuilder lineBuilder = new StringBuilder();

            for (int j = 0; j < message.length(); j++) {

                char ch = message.charAt(j);
                String[] pattern = getCharacterPattern(ch, charMaps);

                lineBuilder.append(pattern[i]).append(" ");
            }

            System.out.println(lineBuilder);
        }
    }

    public static void main(String[] args) {

        CharacterPatternMap[] charMaps = createCharacterPatternMaps();

        String message = "OOPS";

        printMessage(message, charMaps);
    }
}