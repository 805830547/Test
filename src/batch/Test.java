package batch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<ManHour> manHourList = new ArrayList<ManHour>();
        ManHour manHour1 = new ManHour(new BigDecimal("2"));
        ManHour manHour2 = new ManHour(new BigDecimal("2"));
        ManHour manHour3 = new ManHour(new BigDecimal("6"));
        ManHour manHour4 = new ManHour(new BigDecimal("4"));
        ManHour manHour5 = new ManHour(new BigDecimal("1"));
        ManHour manHour6 = new ManHour(new BigDecimal("2"));
        ManHour manHour7 = new ManHour(new BigDecimal("6"));
        ManHour manHour8 = new ManHour(new BigDecimal("4"));

        manHourList.add(manHour1);
        manHourList.add(manHour2);
        manHourList.add(manHour3);
        manHourList.add(manHour4);
        manHourList.add(manHour5);
        manHourList.add(manHour6);
        manHourList.add(manHour7);
        manHourList.add(manHour8);

        Collections.sort(manHourList);

        setManHourRate(manHourList, sumManHour(manHourList));

        BigDecimal sumManHourRate = sumManHourRate(manHourList);
        if(sumManHourRate.compareTo(new BigDecimal("1")) == 0) {
            System.out.println("=========SUCCESS=========");
        } else {
            System.out.println("=========FAILURE=========");
        }
    }

    public static void setManHourRate(List<ManHour> manHourList, BigDecimal totalManHour) {
        BigDecimal totalManHourRateExceptLastIndex = new BigDecimal("0");
        for (int i = 0; i < manHourList.size() -1; i++) {
            manHourList.get(i).setManHourRate(
                    manHourList.get(i).getManHour().divide(totalManHour, 2, BigDecimal.ROUND_HALF_UP));
            totalManHourRateExceptLastIndex = totalManHourRateExceptLastIndex.add(manHourList.get(i).getManHourRate());
        }
        manHourList.get(manHourList.size() -1).setManHourRate(
                new BigDecimal("1").subtract(totalManHourRateExceptLastIndex));
    }

    public static BigDecimal sumManHour(List<ManHour> manHourList) {
        BigDecimal totalManHour = new BigDecimal("0");
        for (ManHour manHour : manHourList) {
            totalManHour = totalManHour.add(manHour.getManHour());
        }
        return totalManHour;
    }

    public static BigDecimal sumManHourRate(List<ManHour> manHourList) {
        BigDecimal totalManHourRate = new BigDecimal("0");
        for (ManHour manHour : manHourList) {
            totalManHourRate = totalManHourRate.add(manHour.getManHourRate());
            System.out.println(manHour.getManHourRate());
        }
        return totalManHourRate;
    }
}

class ManHour implements Comparable<ManHour>{
    private BigDecimal manHour;
    private BigDecimal manHourRate;

    public ManHour() {
        super();
    }

    public ManHour(BigDecimal manHour) {
        super();
        this.manHour = manHour;
    }

    public ManHour(BigDecimal manHour, BigDecimal manHourRate) {
        super();
        this.manHour = manHour;
        this.manHourRate = manHourRate;
    }

    public BigDecimal getManHour() {
        return manHour;
    }
    public void setManHour(BigDecimal manHour) {
        this.manHour = manHour;
    }
    public BigDecimal getManHourRate() {
        return manHourRate;
    }
    public void setManHourRate(BigDecimal manHourRate) {
        this.manHourRate = manHourRate;
    }

    @Override
    public int compareTo(ManHour manHour) {
        // TODO Auto-generated method stub
        return this.getManHour().compareTo(manHour.getManHour());
    }
}
