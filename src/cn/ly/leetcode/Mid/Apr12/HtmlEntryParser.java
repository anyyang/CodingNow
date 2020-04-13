package cn.ly.leetcode.Mid.Apr12;
//https://leetcode-cn.com/contest/weekly-contest-184/problems/html-entity-parser/

public class HtmlEntryParser {
    public String entityParser(String text) {
        if (text == null || "".equals(text) || text.length() < 4) {
            return text;
        }
        // String   regex="/^&.*;$/";
         String   regex="^&.*;";
        if (!regex.matches(regex)) {
            return text;
        }

        String result = "";
        int aindex = text.indexOf("&");
        int bindex = text.indexOf(";");
        if (aindex != -1 && bindex != -1 && bindex - aindex > 2) {
            result += text.substring(0, aindex);
            String zhuanyi = getRealText(text.substring(aindex, bindex + 1));
            result += zhuanyi;
            if (bindex < text.length()) {
                result = result + text.substring(bindex + 1, text.length());
            }
            entityParser(result);
        }

        return result;
    }

    private String getRealText(String substring) {
        String reuslt = substring;
        switch (substring) {
            case "&quot;":
                reuslt = "\"";
                break;
            case "&apos;":
                reuslt = "'";
                break;
            case "&amp;":
                reuslt = "&";
                break;
            case "&gt;":
                reuslt = ">";
                break;
            case "&lt;":
                reuslt = "<";
                break;
            case "&frasl;":
                reuslt = "/";
                break;
            default:
                reuslt = substring;
        }
        return reuslt;
    }

    public static void main(String[] args) {
        HtmlEntryParser parser = new HtmlEntryParser();
        String result =   parser.entityParser("&amp; is an HTML entity but &ambassador; is not.");
        System.out.println(result);
    }
}
