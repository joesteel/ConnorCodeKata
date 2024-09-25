package com.connor.leeteasy;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int g_i = 0, s_i = 0;
        while(g_i < g.length && s_i < s.length){
            if(g[g_i] <= s[s_i]) g_i++;
            else g[g_i] -= s[s_i]; // in the actual solution on l33t this isn't needed as I guess you can't give more than 1 cookie
            s_i++;
        }
        return g_i;
    }
}
