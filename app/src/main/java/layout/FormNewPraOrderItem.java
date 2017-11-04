/******************************************************************************
 Author           : ADI
 Description      : untuk menampilkan detail item pada sales order
 History          :

 ******************************************************************************/
package layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.inspira.babies.GlobalVar;
import com.inspira.babies.LibInspira;
import com.inspira.babies.R;
import static com.inspira.babies.IndexInternal.global;

public class FormNewPraOrderItem extends Fragment implements View.OnClickListener{

    protected TextView tvKodeBarang,tvNamaBarang,tvSatuan;
    protected EditText etJumlah;
    protected Button btnAdd;

    public FormNewPraOrderItem() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_praorder_form_detail_item, container, false);
        getActivity().setTitle("PraOrder - New Item");
        return v;
    }


    /*****************************************************************************/
    //OnAttach dijalankan pada saat fragment ini terpasang pada Activity penampungnya
    /*****************************************************************************/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    //added by Tonny @15-Jul-2017
    //untuk mapping UI pada fragment, jangan dilakukan pada OnCreate, tapi dilakukan pada onActivityCreated
    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);

        tvKodeBarang = (TextView) getView().findViewById(R.id.tvKodeBarang);
        tvNamaBarang = (TextView) getView().findViewById(R.id.tvNamaBarang);
        tvSatuan = (TextView) getView().findViewById(R.id.tvSatuan);

        etJumlah = (EditText) getView().findViewById(R.id.etJumlah);

        btnAdd = (Button) getView().findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        if(LibInspira.getShared(global.temppreferences, global.temp.praorder_index_edit, "").equals(""))
        {
            btnAdd.setText("ADD");
        }
        else
        {
            btnAdd.setText("EDIT");
        }

        tvKodeBarang.setOnClickListener(this);

        refreshData();


//        if(LibInspira.getShared(global.temppreferences, global.temp.salesorder_type_proyek, "").equals("proyek"))
//        {
//            getView().findViewById(R.id.trNotes).setVisibility(View.GONE);
//            getView().findViewById(R.id.trDisc).setVisibility(View.GONE);
//            getView().findViewById(R.id.trFee).setVisibility(View.GONE);
//            getView().findViewById(R.id.trPrice).setVisibility(View.GONE);
//            getView().findViewById(R.id.trNetto).setVisibility(View.GONE);
//            getView().findViewById(R.id.trSubtotal).setVisibility(View.GONE);
//        }

        //init();
    }

    //added by Tonny @02-Sep-2017  untuk inisialisasi textwatcher pada komponen
//    protected void init(){
//        etPrice.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                LibInspira.formatNumberEditText(etPrice, this, true, false);
//                LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_price, etPrice.getText().toString().replace(",", ""));
//                tvNetto.setText(etPrice.getText());
//                refreshData();
//            }
//        });
//
//        etFee.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                LibInspira.formatNumberEditText(etFee, this, true, false);
//                LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_fee, etFee.getText().toString().replace(",", ""));
//                refreshData();
//            }
//        });
//
//        etDisc.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_disc, etDisc.getText().toString().replace(",", ""));
//                refreshData();
//            }
//        });
//
//        etQty.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_qty, etQty.getText().toString().replace(",", ""));
//                refreshData();
//            }
//        });
//
//        etPrice.setText(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_price, "0"));
//        etFee.setText(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_fee, "0"));
//        etDisc.setText(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_disc, "0"));
//        etQty.setText(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_qty, "0"));
//
//        refreshData();
//    }

    protected void refreshData()
    {
//        tvItemReal.setText(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_nama_real, ""));
//        tvCodeReal.setText(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_kode_real, ""));
//        tvItem.setText(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_nama, ""));
//        tvCode.setText(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_kode, ""));

        tvKodeBarang.setText(LibInspira.getShared(global.temppreferences, global.temp.praorder_kode_barang_add, ""));
        tvNamaBarang.setText(LibInspira.getShared(global.temppreferences, global.temp.praorder_nama_barang_add, ""));
        if(!LibInspira.getShared(global.temppreferences, global.temp.praorder_jumlah_add, "").equals("")) {
            etJumlah.setText(LibInspira.getShared(global.temppreferences, global.temp.praorder_jumlah_add, ""));
        }
        tvSatuan.setText(LibInspira.getShared(global.temppreferences, global.temp.praorder_satuan_add, ""));

//        if(etPrice.getText().toString().equals("")){
//            etPrice.setText("0");
////        }else if(etQty.getText().toString().equals("")){
////            etQty.setText("0");
////        }else if(etFee.getText().toString().equals("")){
////            etFee.setText("0");
////        }else if(etDisc.getText().toString().equals("")){
////            etDisc.setText("0");
//        }

//        if(!LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_nama, "").equals(""))
//        {
//            if(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_price, "").equals("")) LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_price, "0");
//            if(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_fee, "").equals("")) LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_fee, "0");
//            if(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_disc, "").equals("")) LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_disc, "0");
//            if(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_qty, "").equals("")) LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_qty, "0");
//
//            Double qty = Double.parseDouble(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_qty, "0"));
//            Double price = Double.parseDouble(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_price, "0"));
//            Double fee = Double.parseDouble(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_fee, "0"));
//            Double disc = Double.parseDouble(LibInspira.getShared(global.temppreferences, global.temp.salesorder_item_disc, "0"));
//
//            Double discNominalPerItem = price * disc / 100;
//            Double netto = price - discNominalPerItem + fee;
//            Double subtotal = netto * qty;
//
//            //added by Tonny @05-Sep-2017
//            LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_subtotal, subtotal.toString());

//            tvDisc.setText(LibInspira.delimeter(String.valueOf(discNominalPerItem)));
//            tvNetto.setText(LibInspira.delimeter(String.valueOf(netto)));
//            tvSubtotal.setText(LibInspira.delimeter(String.valueOf(subtotal)));
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        view.startAnimation(GlobalVar.buttoneffect);
        int id = view.getId();

        LibInspira.setShared(global.sharedpreferences, global.shared.position, "praorder");
        if(id == R.id.tvKodeBarang)
        {
            LibInspira.ReplaceFragment(getActivity().getSupportFragmentManager(), R.id.fragment_container, new ChooseJenisFragment());
        }

        else if (id==R.id.btnAdd) //modified by Tonny @01-Sep-2017
        {
            //urutannya: nomor~kode~nama~satuan~price~qty~fee~disc
            String strData = "";
//            if (etNotes.getText().toString().equals("")){
//                LibInspira.setShared(global.temppreferences, global.temp.salesorder_item_notes, "_");
//            }
            if(LibInspira.getShared(global.temppreferences, global.temp.praorder_kode_barang_add, "").equals("")){
                LibInspira.ShowShortToast(getContext(), "There is no item to add.");
                return;
            }
            else if(LibInspira.getShared(global.temppreferences, global.temp.praorder_menu, "").equals("add_new"))
            {
                //MODE ADD
                LibInspira.setShared(global.temppreferences, global.temp.praorder_jumlah_add, etJumlah.getText().toString());

                strData = LibInspira.getShared(global.temppreferences, global.temp.praorder_item_add, "") + //praorder di bagian depan
                        LibInspira.getShared(global.temppreferences, global.temp.praorder_nomor_add, "") + "~" +
                        LibInspira.getShared(global.temppreferences, global.temp.praorder_nama_barang_add, "") + "~" +
                        LibInspira.getShared(global.temppreferences, global.temp.praorder_kode_barang_add,"") + "~" +
                        LibInspira.getShared(global.temppreferences, global.temp.praorder_nomor_barang_add, "") + "~" +
                        LibInspira.getShared(global.temppreferences, global.temp.praorder_nomor_satuan_add, "") + "~" +
                        LibInspira.getShared(global.temppreferences, global.temp.praorder_satuan_add, "")+ "~" +
                        LibInspira.getShared(global.temppreferences, global.temp.praorder_jumlah_add,"") + "|";



                Log.d("strData add", strData);
            }
            else if(LibInspira.getShared(global.temppreferences, global.temp.praorder_menu, "").equals("edit"))
            {
                //MODE EDIT
                String[] pieces = LibInspira.getShared(global.temppreferences, global.temp.praorder_item_add, "").trim().split("\\|");
                for(int i=0 ; i < pieces.length ; i++){
                    if(i != Integer.parseInt(LibInspira.getShared(global.temppreferences, global.temp.praorder_index_edit, "")))
                    {
                        strData = strData + pieces[i] + "|";
                    }
                    else
                    {
                        LibInspira.setShared(global.temppreferences, global.temp.praorder_jumlah_add, etJumlah.getText().toString());

                        strData = strData + //praorder di bagian depan
                                LibInspira.getShared(global.temppreferences, global.temp.praorder_nomor_add, "") + "~" +
                                LibInspira.getShared(global.temppreferences, global.temp.praorder_nama_barang_add, "") + "~" +
                                LibInspira.getShared(global.temppreferences, global.temp.praorder_kode_barang_add,"") + "~" +
                                LibInspira.getShared(global.temppreferences, global.temp.praorder_nomor_barang_add, "") + "~" +
                                LibInspira.getShared(global.temppreferences, global.temp.praorder_nomor_satuan_add, "") + "~" +
                                LibInspira.getShared(global.temppreferences, global.temp.praorder_satuan_add, "")+ "~" +
                                LibInspira.getShared(global.temppreferences, global.temp.praorder_jumlah_add,"") + "|";

                        Log.d("strData edit", strData);
                    }
                }
            }

            LibInspira.setShared(global.temppreferences, global.temp.praorder_index_edit, "");
            LibInspira.setShared(global.temppreferences, global.temp.praorder_item_add, strData);
            LibInspira.BackFragment(getFragmentManager());
        }
    }
}