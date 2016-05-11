package sbl.com.andprocess.datamodels;

/**
 * Created by sandeep on 24/03/16.
 */
public class SampleParentNotInheritable {
    int x = 0;

    private SampleParentNotInheritable(int a) {
        x = 1;

//        SampleInnerClass sampleInnerClass = new SampleInnerClass();
    }

    public class SampleInnerClass {

        public SampleInnerClass(String x) {
            this(2);
        }

        public SampleInnerClass(int x) {




//            this(2);
        }

//        public SampleInnerClass getInstance() {
//
//            SampleInnerClass  sampleInnerClass = this();
//
//            return
//        }

    }

    public class SampleInnerClassSecond {


    }
}
