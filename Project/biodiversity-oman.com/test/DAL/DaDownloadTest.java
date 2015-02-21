/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Download;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Oualid
 */
public class DaDownloadTest {
    
    public DaDownloadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of selectAllDownload method, of class DaDownload.
     * @throws java.lang.Exception
     */
    @Test
    public void testSelectAllDownload() throws Exception {
        System.out.println("selectAllDownload");
        List<Download> results = DaDownload.selectAllDownload();
        
        for (Download result : results) {
            System.out.println(result.getDownloadFunStuff());
        }
    }

    /**
     * Test of selectOneByIDDownload method, of class DaDownload.
     * @throws java.lang.Exception
     */
    @Test
    public void testSelectOneByIDDownload() throws Exception {
        System.out.println("selectOneByIDDownload");
        int id = DaDownload.selectAllDownload().get(0).getDownloadId();
        Download result = DaDownload.selectOneByIDDownload(id);
        
        System.out.println(result.getDownloadFunStuff());
    }

    /**
     * Test of selectAllByWorldDownload method, of class DaDownload.
     * @throws java.lang.Exception
     */
    @Test
    public void testSelectAllByWorldDownload() throws Exception {
        System.out.println("selectAllByWorldDownload");
        int id = DaDownload.selectAllDownload().get(0).getWorldId();
        List<Download> results = DaDownload.selectAllByWorldDownload(id);
        
        for (Download result : results) {
            System.out.println("Download voor world " + id + ": " + result.getDownloadFunStuff());
        }
    }

    /**
     * Test of insertDownload method, of class DaDownload.
     * @throws java.lang.Exception
     */
    @Test
    public void testInsertDownload() throws Exception {
        System.out.println("insertDownload");
        int[] worlds = {2, 3, 5, 6, 7};
        Download download = new Download();
        download.setWorldId(worlds[(int) (Math.random() * (4 - 0))]);
        download.setDownloadFunStuff("insert test");
        DaDownload.insertDownload(download);
    }

    /**
     * Test of deleteDownload method, of class DaDownload.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteDownload() throws Exception {
        System.out.println("deleteDownload");
        int id = DaDownload.selectAllDownload().get(0).getDownloadId();
        DaDownload.deleteDownload(id);
    }

    /**
     * Test of updateDownload method, of class DaDownload.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateDownload() throws Exception {
        System.out.println("updateDownload");
        Download download = DaDownload.selectAllDownload().get(0);
        download.setDownloadFunStuff("update worked");
        DaDownload.updateDownload(download);
    }
    
}
