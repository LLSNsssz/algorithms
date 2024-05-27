class Solution {
    public String solution(String code) {
        String ret = "";
        String[] arrCode = code.split("");
        int mode = 0;

        for (int i = 0; i < code.length(); i++) {
            if (mode == 0) {
                if (!arrCode[i].equals("1")) {
                    if (i % 2 == 0) {
                        ret += arrCode[i];
                    }
                } else {
                    mode = 1;
                }
            } else if (mode == 1) {
                if (!arrCode[i].equals("1")) {
                    if (i % 2 == 1) {
                        ret += arrCode[i];
                    }
                } else {
                    mode = 0;
                }
            }
        }

        if (ret.isEmpty()) {
            return "EMPTY";
        }

        return ret;
    }
}