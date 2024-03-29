package activity.example.com.eshop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import activity.example.com.eshop.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/6/17.
 */

public class TestFragment extends Fragment {
    private static final String FRAGMENT_TEXT = "fragment_text";
    @BindView(R.id.text)
    TextView mTextView;

    // 对外提供一个创建方法：传递数据
    public static TestFragment newInstance(String text){
        TestFragment testFragment = new TestFragment();

        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_TEXT,text);
        testFragment.setArguments(bundle);

        return testFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category,container,false);
        ButterKnife.bind(this,view);
        mTextView.setText(getArgumentText());
        return view;
    }

    public String getArgumentText(){
        return getArguments().getString(FRAGMENT_TEXT);
    }
}
