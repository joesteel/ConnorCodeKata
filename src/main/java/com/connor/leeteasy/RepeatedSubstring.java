package com.connor.leeteasy;

public class RepeatedSubstring {

    public static boolean repeatedSubstringPattern(String s) {
        // can we do this recursively?
        // pass the segment start, end and string , if no match it's false, otherwise next segment and if segment start == string end then return true

        int segments = 1;
        while(segments <= s.length()){
            segments += 1; // min two segments
            if(s.length() % segments != 0) continue;
            int segment_end = s.length()/segments;
            boolean all_segments_match = false;
            String working_substr = s.substring(0, segment_end);
            for(int i = 1; i < segments; i++){ // do the segments repeat?
                all_segments_match = true;
                if(!working_substr.equals(s.substring(segment_end*i, ((segment_end*i) + segment_end)) )) {
                    all_segments_match = false;
                    break;
                }
            }
            if(all_segments_match) return true;
        }
        return false;
    }

}
