import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> resultSet = parse(expression);
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }

    private Set<String> parse(String expr) {
        Set<String> res = new HashSet<>();
        List<Set<String>> currentGroup = new ArrayList<>();
        
        int n = expr.length();
        int i = 0;

        while (i < n) {
            char c = expr.charAt(i);

            if (c == '{') {
                // Find matching closing brace for this sub-expression
                int start = i;
                int openBraces = 0;
                while (i < n) {
                    if (expr.charAt(i) == '{') openBraces++;
                    else if (expr.charAt(i) == '}') openBraces--;
                    if (openBraces == 0) break;
                    i++;
                }
                
                // Recursively parse the content inside braces
                Set<String> subSet = parse(expr.substring(start + 1, i));
                
                if (currentGroup.isEmpty()) {
                    currentGroup.add(subSet);
                } else {
                    // Implicit concatenation (Cartesian product)
                    Set<String> lastSet = currentGroup.remove(currentGroup.size() - 1);
                    currentGroup.add(product(lastSet, subSet));
                }
                i++;
            } else if (c == ',') {
                // End current concatenated group and add to union set
                res.addAll(union(currentGroup));
                currentGroup.clear();
                i++;
            } else {
                // Read continuous lowercase letters
                int start = i;
                while (i < n && Character.isLowerCase(expr.charAt(i))) {
                    i++;
                }
                String str = expr.substring(start, i);
                Set<String> letterSet = new HashSet<>(Collections.singletonList(str));

                if (currentGroup.isEmpty()) {
                    currentGroup.add(letterSet);
                } else {
                    // Implicit concatenation (Cartesian product)
                    Set<String> lastSet = currentGroup.remove(currentGroup.size() - 1);
                    currentGroup.add(product(lastSet, letterSet));
                }
            }
        }

        res.addAll(union(currentGroup));
        return res;
    }

    private Set<String> union(List<Set<String>> list) {
        Set<String> res = new HashSet<>();
        for (Set<String> set : list) {
            res.addAll(set);
        }
        return res;
    }

    private Set<String> product(Set<String> set1, Set<String> set2) {
        Set<String> res = new HashSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                res.add(s1 + s2);
            }
        }
        return res;
    }
}