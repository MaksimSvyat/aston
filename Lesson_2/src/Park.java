import java.util.ArrayList;
import java.util.List;

public class Park {
    private final String parkName;
    private final List<Attraction> attractions;

    public Park(String name) {
        this.parkName = name;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Park name: ").append(parkName).append("\n");
        sb.append("Attractions:\n");
        for (Attraction attraction : attractions) {
            sb.append("- ").append(attraction.toString()).append("\n");
        }
        return sb.toString();
    }

    public static class Attraction {
        private final String attractionName;
        private final String workingHours;
        private final double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.attractionName = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Attraction name: " + attractionName + "\n"
                    + "Working Hours: " + workingHours + "\n"
                    + "Cost: " + cost;
        }
    }
}
