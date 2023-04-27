package Core.Services;

import Core.Models.Toy;

import java.util.ArrayList;
import java.util.List;

public class DrawingService {
    private final List<Toy> toys;

    public DrawingService() {
        this.toys = new ArrayList<>();
    }

    public boolean putForDrawing(Toy toy) {
        boolean flag = false;
        if (!toys.contains(toy)) {
            this.toys.add(toy);
            flag = true;
        }
        return flag;
    }
}
