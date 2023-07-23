package com.example.myapplication.codingminutes_levelup.binarysearch;

import java.util.Arrays;

/**
 * Reading Books
 * Given number of pages inn different books and m students The books are arranged in any order (not necessarily ascending) of number of pages.
 * Every student is assigned to read some consecutive segment of books.
 * The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
 * Find the maximum number of pages that a student will have to read.
 * <p>
 * Sample Input
 * <p>
 * books = [10, 20,30,15]
 * students = 2
 * <p>
 * Sample Output
 * 45
 */
public class ReadingBooks {
    public static void main(String[] args) {
        int[] books = {10, 20, 30, 15};
        int students = 2;
        int result = minimumNumPages(books, students);
        System.out.println("Result:" + result);
    }

    static int minimumNumPages(int[] books, int students) {
        int n = books.length;
        int s = 0;
        int e = 0;
        int ans = Integer.MAX_VALUE;
        Arrays.sort(books);
        //find maximum num of pages
        for (int page : books) {
            e += page;
            s = Math.max(s, page);
        }
        System.out.println("E:"+e);
        System.out.println("S:"+s);
        while (s <= e) {
            int mid = (s + e) / 2;
            System.out.println("mid:"+mid);
            boolean isPossible = isMinPagePossible(books, n, students, mid);
            if (isPossible) {
                ans = Math.min(ans, mid);
                System.out.println("ANS:"+ans);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isMinPagePossible(int[] books, int n, int students, int mid) {
        int currentStudentPages = 0;
        int numOfStudents = 1;

        for (int i = 0; i < n; i++) {
            if (currentStudentPages + books[i] > mid) {
                numOfStudents += 1;
                currentStudentPages = books[i];

                if (numOfStudents > students) {
                    return false;
                }

            } else {
                currentStudentPages += books[i];
            }
        }
        return true;
    }
}
