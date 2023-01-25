package sumo.desktop_server.Controllers.Utils.Report.Compare;

import sumo.desktop_server.Controllers.Utils.Report.NationalClassificationRecord;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BronzeMedalSorter implements Comparator<List<NationalClassificationRecord>> {

    @Override
    public int compare(List<NationalClassificationRecord> o1, List<NationalClassificationRecord> o2) {
        AtomicInteger sumOfBronzes = new AtomicInteger(0);
        o1.forEach(nationalClassificationRecord -> {
            if (nationalClassificationRecord.placement() == 3)
                sumOfBronzes.addAndGet(1);
        });

        AtomicInteger sumOfBronzes1 = new AtomicInteger(0);
        o2.forEach(nationalClassificationRecord1 -> {
            if (nationalClassificationRecord1.placement() == 3)
                sumOfBronzes1.addAndGet(1);
        });

        return Integer.compare(sumOfBronzes.get(), sumOfBronzes1.get());
    }
}
