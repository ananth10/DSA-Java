package com.example.myapplication.codingminutes_levelup.stack_and_quick;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Simplify Path
 * -------------
 * <p>
 * In this coding challenge, we will build a functionality for a command line tool. We want to write a function that takes in a non-empty string representing a valid Unix-shell path and returns a simplified version of the path. The simplified path must be equivalent to the original path, that means it should point to same file/directory as the original path.
 * A path can be an absolute path, meaning that it starts at the root directory in a file system, or a relative path, meaning that it starts at the current directory in a file system. In a Unix-like Operating System, a path is bounded by the following rules:
 * The root directory is represented by a /. This means that if a path start with /, it's an absolute path; if it doesn't, it's a relative path.
 * The symbol / otherwise represent the directory separator. This means that the path /x/y is location of directory y inside directory x, which is itself located inside the root directory.
 * The symbol .. represents the parent directory. This means that accessing files or directories in /x/y/.. is equivalent to accessing files or directories in /x
 * They symbol . represents the current directory. This means that accessing files or directories in /x/y/. is equivalent to accessing files or directories in /x/y
 * The symbols / and . can be repeated sequentially without consequence; the symbol .. cannot, however repeating it sequentially means going further up in the parent directories. For example, /x/y/z/././.
 * and /x/y/z are equivalent. and /x/y/z/../../... and /x/y/z aren't. The only exception is with the root directory : /../../.. and / are equivalent because the root directory has no parent directory, which means repeated accessing parent directories does nothing.
 * Summary
 * "/a/./"   --> means stay at the current directory 'a'
 * <p>
 * "/a/b/.." --> means jump to the parent directory
 * from 'b' to 'a'
 * <p>
 * "////"    --> consecutive multiple '/' are a  valid
 * path, they are equivalent to single "/".
 * Examples
 * Input : /a/./b/../../c/
 * Output : /c
 * <p>
 * Input : /a/..
 * Output:/
 * <p>
 * Input : /a///b
 * Output : /a/b
 * <p>
 * Input : /a/../
 * Output : /
 * <p>
 * Input : /../../../../../a
 * Output : /a
 * <p>
 * Input : /a/./b/./c/./d/
 * Output : /a/b/c/d
 * <p>
 * Input : /a/../.././../../.
 * Output:/
 */
public class SimplifyPath {
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    public static void main(String[] args) {
        String path = "/../x/y/../z/././w/a///../../c/./";
        System.out.println("Input: " + path);
        String result = simplifyPath(path);
        System.out.println("Result: " + result);
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    private static String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        //step 1 - tokenization and filter the unwanted items
        String[] token = path.split("/");
        for (int i = 0; i < token.length; i++) {
            if (token[i].equals(".") || token[i].equals("")) {
                continue;
            }
            list.add(token[i].trim());
        }
        List<String> stack = new ArrayList<>();

        //step 2 - handle absolute/relative path and remove ".."
        if (path.charAt(0) == '/') {
            stack.add(""); //special char to represent absolute path
        }
        //step 2 - handle ".."
        for (int i = 0; i < list.size(); i++) {
            //remove previous dir, if current item is ".."

            if (list.get(i).equals("..")) {

                if (stack.size() == 0 || stack.get(stack.size() - 1).equals("..")) { //which means token starts with ".." or the previous token is ".." means is a relative path so we should push it to stack
                    stack.add("..");
                } else if (!stack.get(stack.size() - 1).equals("")) { // previous token is not an absolute path then remove it from stack
                    stack.remove(stack.get(stack.size() - 1)); //remove previous token
                }
            } else {
                stack.add(list.get(i));
            }
        }

        //step3 - combine all tokens from the stack
        if (stack.size() == 1 && stack.get(0).equals("")) {
            return result.append("/").toString();
        }
        int index = 0;
        for (String toke : stack) {
            if (index != 0) {
                result.append("/");
            }
            result.append(toke);
            index++;
        }
        return result.toString();
    }
}
