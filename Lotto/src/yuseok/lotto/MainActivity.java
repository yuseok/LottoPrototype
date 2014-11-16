package yuseok.lotto;

import java.util.ArrayList;
import java.util.HashSet;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	EditText mEdit;
	TextView mText;
	ListView mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mEdit = (EditText) findViewById(R.id.editText1);
		mText = (TextView) findViewById(R.id.textView1);
		mList = (ListView) findViewById(R.id.listView1);
		mList.setAdapter(adapter);

		findViewById(R.id.button1).setOnClickListener(btnOnClickListener);

	}

	ArrayAdapter<Integer[]> adapter = new ArrayAdapter<Integer[]>(this,
			android.R.layout.simple_list_item_1);

	Button.OnClickListener btnOnClickListener = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.button1) {
				int cnt = Integer.parseInt(mEdit.getText().toString());
				int result[][] = new int[cnt][6];
				
				result = new CreateSix().create(cnt);
				

			}

		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class CreateSix {

		private HashSet<Integer> hash;
		private ArrayList<HashSet<Integer>> array;

		public int[][] create(int length) {

			int result[][] = new int[length][6];
			array = new ArrayList<HashSet<Integer>>();
			for (int i = 0; i < length; i++) {
				hash = new HashSet<Integer>();
				while (true) {
					hash.add(((int) (Math.random() * 45) + 1));
					if (hash.size() == 6) {
						break;
					}
				}
				array.add(hash);
			}
			int a = 0;
			int b = 0;

			for (HashSet<Integer> set : array) {
				for (int i : set) {
					result[a][b] = i;
					b++;
				}
				a++;
				b = 0;

			}
			return result;

		}
	}
}
