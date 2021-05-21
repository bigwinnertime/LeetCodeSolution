package org.bigwinner.leetcode.Simple.String;

import java.util.Stack;

/**
 * @author: bigwinner
 * @date: 2020/7/20 5:28 下午
 * @version: 1.0.0
 * @description: 判断有效的括号
 */
public class IsValid_20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *  
     *
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     * 示例 4：
     *
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     *
     * 输入：s = "{[]}"
     * 输出：true
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        // 注意空字符串可被认为是有效字符串
        if (s.length() == 0) return true;
        Stack<String> stack = new Stack<>();
        String[] strs = s.split("");
        for (String str : strs) {
            // 栈空则push数据，并直接继续下一次循环
            if (stack.size() == 0) {
                stack.push(str);
                continue;
            }
            // 如果栈顶元素与要push的元素成对，则pop栈顶元素，反之push到栈中
            if (str.equals(getPairVal1(stack.peek()))) stack.pop();
            else stack.push(str);
        }
        // 循环结束，如果栈空则说明字符串有效，反之则无效
        if (stack.size() == 0) return true;
        else return false;
    }

    public boolean isValid2(String s) {
        // 注意空字符串可被认为是有效字符串
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (Character str : s.toCharArray()) {
            // 栈空则push数据，并直接继续下一次循环
            if (stack.size() == 0) {
                stack.push(str);
                continue;
            }
            // 如果栈顶元素与要push的元素成对，则pop栈顶元素，反之push到栈中
            if (str == getPairVal2(stack.peek())) stack.pop();
            else stack.push(str);
        }
        // 循环结束，如果栈空则说明字符串有效，反之则无效
        if (stack.size() == 0) return true;
        else return false;
    }

    public boolean isValid3(String s) {
        // 注意空字符串可被认为是有效字符串
        if (s.length() == 0) return true;
        if (s.length() % 2 != 0 || ! (s.contains("()") || s.contains("{}") || s.contains("[]"))) return false;
        Stack<Character> sta = new Stack<>();
        for (Character str : s.toCharArray()) {
            // 栈空则push数据，并直接继续下一次循环
            if (sta.size() == 0) {
                sta.push(str);
                continue;
            }
            // 如果栈顶元素与要push的元素成对，则pop栈顶元素，反之push到栈中
            if (str == getPairVal2(sta.peek())) sta.pop();
            else sta.push(str);
        }
        // 循环结束，如果栈空则说明字符串有效，反之则无效
        if (sta.size() == 0) return true;
        else return false;

    }

    private String getPairVal1(String s) {
        String res = "";
        switch(s){
            case "(":
                res = ")";
                break;
            case "[":
                res = "]";
                break;
            case "{":
                res = "}";
                break;
        }
        return res;
    }

    private Character getPairVal2(char s) {
        Character res = ' ';
        switch(s){
            case '(':
                res = ')';
                break;
            case '[':
                res = ']';
                break;
            case '{':
                res = '}';
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new IsValid_20().isValid3(""));  // true
        System.out.println(new IsValid_20().isValid3("()[]{}")); // true
        System.out.println(new IsValid_20().isValid3("([)]"));  // false
        System.out.println(new IsValid_20().isValid3("{[]}"));  // true
    }
}
