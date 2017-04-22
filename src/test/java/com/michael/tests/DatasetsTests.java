package com.michael.tests;

import com.michael.models.Column;
import com.michael.models.Dataset;
import com.michael.models.DatasetInfo;
import com.michael.models.Datasets;
import com.michael.services.APIService;
import com.michael.services.RetrofitBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by maste on 4/16/2017.
 */
public class DatasetsTests {

    private APIService apiService;

    @BeforeMethod
    public void setUp() throws Exception {
        apiService = RetrofitBuilder.getRetrofit().create(APIService.class);
    }
    
    @Test
    public void testLimitedNumberOfRecords() throws Exception {
        Datasets datasets = apiService.getDatasets(7, 0).execute().body();

        Assert.assertEquals(7, datasets.getItems().size());
    }

    @Test
    public void testSortedDatasets() throws Exception {
        Datasets datasets = apiService.getDatasetsWithSort(14, 0, "Id").execute().body();

        long previousId = -1;

        for (Dataset dataset : (List<Dataset>)datasets.getItems()) {
            Assert.assertTrue(dataset.getId() >= previousId, "Current Id: " + dataset.getCategoryId() + " previousId: " + previousId);
            previousId = dataset.getId();
        }
    }

    @Test
    public void testReturnsFaithfulDatasetInfo () throws Exception {
        DatasetInfo datasetInfo = apiService.getDatasetInfo(658).execute().body();
        Assert.assertEquals(658, datasetInfo.getId());
        Assert.assertEquals("Дороги и транспорт", datasetInfo.getCategoryCaption());
    }

    @Test
    public void testReturnDatasetByCaption() throws Exception {
        List<Dataset> datasets = apiService.getDatasetByCaption("Caption eq 'Кинотеатры'").execute().body();
        Assert.assertEquals(1, datasets.size());
        Assert.assertEquals("Кинотеатры", datasets.get(0).getCaption());
    }

    @Test
    public void testDatasetHasAllNeedColumns() throws Exception {
        DatasetInfo datasetInfo = apiService.getDatasetInfo(658).execute().body();

        Assert.assertEquals(9, datasetInfo.getColumns().size());

        List<String> columnsNames = new ArrayList<>();
        columnsNames.add("NameOfTariff");
        columnsNames.add("TicketZone");
        columnsNames.add("NumberOfZone");
        columnsNames.add("TariffDistance");
        columnsNames.add("TypeOfTransport");
        columnsNames.add("NameOfCarrier");
        columnsNames.add("TicketCost");
        columnsNames.add("TicketValidity");
        columnsNames.add("global_id");

        List<Column> columns = datasetInfo.getColumns();

        for (Column column : columns) {
            Assert.assertTrue(columnsNames.contains(column.getName()));
        }
    }
}
