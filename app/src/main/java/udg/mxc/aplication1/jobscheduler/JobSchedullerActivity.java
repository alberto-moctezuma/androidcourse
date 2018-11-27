package udg.mxc.aplication1.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.Util;

public class JobSchedullerActivity extends AppCompatActivity {

    private static String TAG = JobSchedullerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_scheduller);
        ButterKnife.bind(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick( R.id.buttonStartJob ) public void shceduleJob(View view){
        ComponentName componentName = new ComponentName( this, ExampleJobService.class );
        JobInfo jobInfo = new JobInfo.Builder( 123, componentName )
                .setRequiresCharging(false)
                .setRequiredNetworkType( JobInfo.NETWORK_TYPE_UNMETERED )
                .setPersisted(true)
                .setPeriodic(15*60*1000)
                .build();

        JobScheduler scheduler = (  JobScheduler ) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = scheduler.schedule(jobInfo);
        if( resultCode == JobScheduler.RESULT_SUCCESS ){
            Util.showLog(TAG, "Job scheduled success");
        }else{
            Util.showLog(TAG, "|xXx| Job scheduling failed |xXx|");
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick( R.id.buttonStopJob ) public void cancelJob(View view ){
        JobScheduler scheduler = ( JobScheduler ) getSystemService( JOB_SCHEDULER_SERVICE );
        scheduler.cancel(123);
        Util.showLog(TAG, "job cancelled");
    }
}
