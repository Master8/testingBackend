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
    public void testDatasetHasAllNeedColumns() throws Exception {
        DatasetInfo datasetInfo = apiService.getDatasetInfo(658).execute().body();

        Assert.assertEquals(9, datasetInfo.getColumns().size());

        List<Column> columns = datasetInfo.getColumns();

        boolean hasGlobal_Id = false;
        boolean hasTicketValidity = false;
        boolean hasTicketCost = false;
        boolean hasNameOfCarrier = false;
        boolean hasTypeOfTransport = false;
        boolean hasTariffDistance = false;
        boolean hasNumberOfZone = false;
        boolean hasTicketZone = false;
        boolean hasNameOfTariff = false;

        for (Column column : columns) {
            switch (column.getName()) {
                case "NameOfTariff":
                    hasNameOfTariff = true;
                    break;
                case "TicketZone":
                    hasTicketZone = true;
                    break;
                case "NumberOfZone":
                    hasNumberOfZone = true;
                    break;
                case "TariffDistance":
                    hasTariffDistance = true;
                    break;
                case "TypeOfTransport":
                    hasTypeOfTransport = true;
                    break;
                case "NameOfCarrier":
                    hasNameOfCarrier = true;
                    break;
                case "TicketCost":
                    hasTicketCost = true;
                    break;
                case "TicketValidity":
                    hasTicketValidity = true;
                    break;
                case "global_id":
                    hasGlobal_Id = true;
                    break;
            }
        }

        Assert.assertTrue(hasGlobal_Id);
        Assert.assertTrue(hasTicketValidity);
        Assert.assertTrue(hasTicketCost);
        Assert.assertTrue(hasNameOfCarrier);
        Assert.assertTrue(hasTypeOfTransport);
        Assert.assertTrue(hasTariffDistance);
        Assert.assertTrue(hasNumberOfZone);
        Assert.assertTrue(hasTicketZone);
        Assert.assertTrue(hasNameOfTariff);
    }
}
