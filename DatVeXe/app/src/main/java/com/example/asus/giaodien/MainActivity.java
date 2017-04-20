package com.example.asus.giaodien;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView LVXe;
    ArrayList<ChuyenXe> listXe;
    ChuyenXeAdapter ChuyenXeAdapter;

    static public boolean KiemTraDN = false;
    ArrayList<TaiKhoan> listTK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LVXe=(ListView)findViewById(R.id.list001);
        ListInit();
        addTK();
        ChuyenXeAdapter=new ChuyenXeAdapter(MainActivity.this, R.layout.row_chuyenxe, listXe);
        LVXe.setAdapter(ChuyenXeAdapter);
    }

    //Tạo list chuyến xe cho ListView
    private void ListInit() {
        listXe = new ArrayList<ChuyenXe>();
        listXe.add(new ChuyenXe("Nhà Xe 1", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 2", "Hải Phòng", "Cà Mau", "500,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 3", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 4", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 5", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 6", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 7", "TP HCM", "Hà Nội", "100,000 Đ"));
    }

    //thêm một số tài khoản vào listTK
    private void addTK()
    {
        listTK=new ArrayList<TaiKhoan>();
        listTK.add(new TaiKhoan("hung","123456"));
        listTK.add(new TaiKhoan("dragodrex237","hishiroxtra"));
    }

    //Tạo menu actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //Xử lý searchview
        MenuItem searchitem=menu.findItem(R.id.menu_search);
        SearchView sw= (SearchView) searchitem.getActionView();
        sw.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ChuyenXeAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ChuyenXeAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    //Xử lý sự kiện khi click vào item trên actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        switch (id)
        {
            //ĐĂNG NHẬP
            case R.id.menu_dn:
                if(MainActivity.KiemTraDN==true) {
                    Toast.makeText(this, "Bạn đã đăng nhập", Toast.LENGTH_SHORT).show();
                    return true;
                }
                final Dialog dialog=new Dialog(MainActivity.this);
                dialog.setTitle("SIGN IN");
                dialog.setContentView(R.layout.layout_dangnhap);
                Button btDN = (Button) dialog.findViewById(R.id.btDN);
                Button btOUT= (Button) dialog.findViewById(R.id.btOUT);
                final EditText edID= (EditText) dialog.findViewById(R.id.edID);
                final EditText edPW= (EditText) dialog.findViewById(R.id.edPW);

                
                dialog.show();
                btDN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String id01=edID.getText().toString();
                        String pw01=edPW.getText().toString();
                        boolean dangnhap=false;
                        for(int i=0; i<listTK.size(); i++)
                        {
                            String id02=listTK.get(i).getId();
                            String pw02=listTK.get(i).getPassword();
                            if(id01.contains(id02) && pw01.contains(pw02))
                            {
                                dangnhap=true;
                            }
                        }
                        if(dangnhap==true) {
                            MainActivity.KiemTraDN=true;
                            Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            TextView txt001=(TextView)findViewById(R.id.txt002) ;
                            txt001.setText("Chào mừng " + id01 + " đến với ứng dụng đặt vé");
                            dialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                btOUT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                break;
            //ĐĂNG XUẤT
            case R.id.menu_dx:
                MainActivity.KiemTraDN=false;
                Toast.makeText(this, "Bạn đã đăng xuất", Toast.LENGTH_SHORT).show();
                break;
            //ĐĂNG KÝ
            case R.id.menu_dk:
                final Dialog dialogDK=new Dialog(MainActivity.this);
                dialogDK.setTitle("SIGN UP");
                dialogDK.setContentView(R.layout.layout_dangky);
                Button btDK = (Button) dialogDK.findViewById(R.id.btDKTK);
                Button btOUTDK= (Button) dialogDK.findViewById(R.id.btOUTDK);
                final EditText edIDDK= (EditText) dialogDK.findViewById(R.id.edIDDK);
                final EditText edPWDK= (EditText) dialogDK.findViewById(R.id.edPWDK);
                final EditText edPWCFDK= (EditText) dialogDK.findViewById(R.id.edCFPWDK);
                dialogDK.show();

                btDK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String iddk=edIDDK.getText().toString();
                        String pwdk=edPWDK.getText().toString();
                        String pwcf=edPWCFDK.getText().toString();
                        boolean KTID=true;
                        boolean KTPW=false;
                        for(int i=0; i<listTK.size();i++)
                        {
                            String id02=listTK.get(i).getId();
                            if(iddk.equals(id02))
                            {
                                KTID=false;
                            }
                        }
                        if(pwdk.equals(pwcf))
                            KTPW=true;

                        if(KTID==false) {
                            Toast.makeText(MainActivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                        }

                        else if(KTPW==false) {
                            Toast.makeText(MainActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                        }

                        else if(KTID==true && KTPW==true)
                        {
                            Toast.makeText(MainActivity.this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();
                            listTK.add(new TaiKhoan(iddk, pwdk));
                            dialogDK.dismiss();
                        }
                    }
                });
                btOUTDK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogDK.dismiss();
                    }
                });
                
                break;
        }
        return true;
    }


}
