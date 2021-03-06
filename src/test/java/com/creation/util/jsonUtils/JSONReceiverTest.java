package com.creation.util.jsonUtils;

import com.creation.core.utils.json.file.JSONReceiver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class JSONReceiverTest {
    JSONReceiver jReceiver;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Testing JSONReceiver class");
    }

    @Before
    public void setUp() {
        jReceiver = new JSONReceiver("test");
    }

    /*@Test
    public void whenTakeArrayWhenArrayIsMissing() throws Exception {
        ArrayList<String> params = new ArrayList<>();
        params.add("name");
        try{
            ArrayList<String> listParams = new ArrayList<>();
            listParams.add("nume");//неверный параметр
            HashMap<String,ArrayList> r = jReceiver.getArray(listParams);
            for(ArrayList list : r.values()){
                list.get(0);
            }
        }
        catch (Exception e){
            throw new Exception("Попытка чтения неопределенного массива из JSON");
        }
    }*/
}
