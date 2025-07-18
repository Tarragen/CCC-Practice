import java.util.*;
public class j4_17_favouriteTimes {
    public static void main(String[] args) {
        int patternAppearance = 0;
        final int minPerRotation = 720;
        final int patternNum = 31;
        Scanner sc = new Scanner(System.in);
        int min = Integer.parseInt(sc.nextLine());
        int rotateOverTimes = min / minPerRotation;
        int remainingRotation = min % minPerRotation;

        patternAppearance += patternNum*rotateOverTimes;

        if(remainingRotation > 0) {
            if (remainingRotation >= 671) {
                patternAppearance+=31;
            } else if (remainingRotation >= 591) {
                patternAppearance+=30;
            } else if (remainingRotation >= 532) {
                patternAppearance+=29;
            } else if (remainingRotation >= 520) {
                patternAppearance+=28;
            } else if (remainingRotation >= 473) {
                patternAppearance+=27;
            } else if (remainingRotation >= 461) {
                patternAppearance+=26;
            } else if (remainingRotation >= 414) {
                patternAppearance+=25;
            } else if (remainingRotation >= 402) {
                patternAppearance+=24;
            } else if (remainingRotation >= 390) {
                patternAppearance+=23;
            } else if (remainingRotation >= 355) {
                patternAppearance+=22;
            } else if (remainingRotation >= 343) {
                patternAppearance+=21;
            } else if (remainingRotation >= 331) {
                patternAppearance+=20;
            } else if (remainingRotation >= 296) {
                patternAppearance+=19;
            } else if (remainingRotation >= 284) {
                patternAppearance+=18;
            } else if (remainingRotation >= 272) {
                patternAppearance+=17;
            } else if (remainingRotation >= 260) {
                patternAppearance+=16;
            } else if (remainingRotation >= 237) {
                patternAppearance+=15;
            } else if (remainingRotation >= 225) {
                patternAppearance+=14;
            } else if (remainingRotation >= 213) {
                patternAppearance+=13;
            } else if (remainingRotation >= 201) {
                patternAppearance+=12;
            } else if (remainingRotation >= 178) {
                patternAppearance+=11;
            } else if (remainingRotation >= 166) {
                patternAppearance+=10;
            } else if (remainingRotation >= 154) {
                patternAppearance+=9;
            } else if (remainingRotation >= 142) {
                patternAppearance+=8;
            } else if (remainingRotation >= 130) {
                patternAppearance+=7;
            } else if (remainingRotation >= 119) {
                patternAppearance+=6;
            } else if (remainingRotation >= 107) {
                patternAppearance+=5;
            } else if (remainingRotation >= 95) {
                patternAppearance+=4;
            } else if (remainingRotation >= 83) {
                patternAppearance+=3;
            } else if (remainingRotation >= 71) {
                patternAppearance+=2;
            } else if (remainingRotation >= 34) {
                patternAppearance+=1;
            }
        }
        System.out.println(patternAppearance);
    }
}
