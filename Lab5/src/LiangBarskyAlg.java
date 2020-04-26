import java.util.ArrayList;
import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeMath.max;
import static jdk.nashorn.internal.objects.NativeMath.min;

public class LiangBarskyAlg {



    public static ArrayList<Integer> calc(ArrayList<Integer> line, ArrayList<Integer> rect){
        int x1 = line.get(0);
        int y1 = line.get(1);
        int x2 = line.get(2);
        int y2 = line.get(3);
        int xmin = rect.get(0);
        int ymin = rect.get(1);
        int xmax = rect.get(2);
        int ymax = rect.get(3);

        int dx = x2 - x1;
        int dy = y2 - y1;

        ArrayList<Integer> in = new ArrayList<>();

        int[] S = new int[]{-dy, -dx, dy, dx};
        int[] Q = new int[]{y1 - ymin, x1 - xmin, ymax - y1, xmax - x1 };
        double tvh = 0, tvih = 1;
        for(int i = 0; i < 4; ++i){
            if(S[i] > 0){
                tvih = Math.min((double)Q[i]/S[i], tvih);
            }
            if(S[i] < 0){
                tvh = Math.max((double)Q[i]/S[i], tvh);
            }
            if(S[i] == 0){
                if(Q[i] < 0)
                    return in;
            }
        }

        int x1new = (int)(x1 + tvh * (x2 - x1));
        int y1new = (int)(y1 + tvh * (y2 - y1));
        int x2new = (int)(x1 + tvih * (x2 - x1));
        int y2new = (int)(y1 + tvih * (y2 - y1));

        if(x1new < xmin || x1new > xmax ||  x2new < xmin || x2new > xmax ||
                y1new < ymin || y1new > ymax ||  y2new < ymin || y2new > ymax){
            return in;
        }

        in.add(x1new);
        in.add(y1new);
        in.add(x2new);
        in.add(y2new);

        return in;
    }
}
