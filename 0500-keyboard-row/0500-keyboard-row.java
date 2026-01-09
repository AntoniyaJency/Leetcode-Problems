class Solution {
    public String[] findWords(String[] words) {

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        ArrayList<String> result = new ArrayList<>();

        for (String word : words) {

            String lower = word.toLowerCase();
            char first = lower.charAt(0);

            String row = "";

            if (row1.indexOf(first) != -1) {
                row = row1;
            } else if (row2.indexOf(first) != -1) {
                row = row2;
            } else {
                row = row3;
            }

            boolean sameRow = true;

            for (int i = 0; i < lower.length(); i++) {
                if (row.indexOf(lower.charAt(i)) == -1) {
                    sameRow = false;
                    break;
                }
            }

            if (sameRow) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
