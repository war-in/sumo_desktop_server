package sumo.desktop_server.Controllers.Utils.Report.Compare;

import sumo.desktop_server.Controllers.Utils.Report.NationalClassificationRecord;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GoldMedalSorter implements Comparator<List<NationalClassificationRecord>> {

    @Override
    public int compare(List<NationalClassificationRecord> o1, List<NationalClassificationRecord> o2) {

            AtomicInteger sumOfGolds = new AtomicInteger(0);
            o1.forEach(nationalClassificationRecord -> {
                if (nationalClassificationRecord.placement() == 1)
                    sumOfGolds.addAndGet(1);
            });

            AtomicInteger sumOfGolds1 = new AtomicInteger(0);
            o2.forEach(nationalClassificationRecord1 -> {
                if (nationalClassificationRecord1.placement() == 1)
                    sumOfGolds1.addAndGet(1);
            });

            return Integer.compare(sumOfGolds.get(),sumOfGolds1.get());
    }
}

