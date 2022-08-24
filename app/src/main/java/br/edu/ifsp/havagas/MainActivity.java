package br.edu.ifsp.havagas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import br.edu.ifsp.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.buttonCadastrar.setOnClickListener(view -> {
                    Candidato candidato = getCandidato();

                    String toastText = candidato.toString();

                    if (activityMainBinding.ckCelular.isChecked())
                        toastText += "\n\tCelular: " + activityMainBinding.inputCelular.getText().toString();

                    if (activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Fundamental") ||
                            activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Médio") ||
                            activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Graduação") ||
                            activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Especialização") ||
                            activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Mestrado") ||
                            activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Doutorado")) {
                        toastText += "\n\tAno de conclusão: " + activityMainBinding.inputAnoConclusao.getText().toString();
                    }

                    if (activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Graduação") ||
                            activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Especialização") ||
                            activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Mestrado") ||
                            activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Doutorado")) {
                        toastText += "\n\tInstituição: " + activityMainBinding.inputInstituicao.getText().toString();
                    }

                    if (activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Mestrado") ||
                            activityMainBinding.spinnerFormacao.getSelectedItem().toString().equals("Doutorado")) {
                        toastText += "\n\tTítulo: " + activityMainBinding.inputPosGraduacaoTitulo.getText().toString();
                        toastText += "\n\tOrientador: " + activityMainBinding.inputOrientador.getText().toString();
                    }

                    Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
                }
        );

        activityMainBinding.buttonLimpar.setOnClickListener(view -> {
            activityMainBinding.inputNome.getText().clear();
            activityMainBinding.inputEmail.getText().clear();
            activityMainBinding.ckEmail.setChecked(false);
            activityMainBinding.spinnerTipoTelefone.setSelection(0);
            activityMainBinding.inputTelefone.getText().clear();
            activityMainBinding.ckCelular.setChecked(false);
            activityMainBinding.inputCelular.getText().clear();
            activityMainBinding.radioButtonFeminino.setChecked(true);
            activityMainBinding.inputNascimento.getText().clear();
            activityMainBinding.inputVagasDeInteresse.getText().clear();
            activityMainBinding.spinnerFormacao.setSelection(0);
            activityMainBinding.inputAnoConclusao.getText().clear();
            activityMainBinding.inputInstituicao.getText().clear();
            activityMainBinding.inputPosGraduacaoTitulo.getText().clear();
            activityMainBinding.inputOrientador.getText().clear();
        });

        activityMainBinding.ckCelular.setOnClickListener(view -> {
            if (activityMainBinding.ckCelular.isChecked())
                activityMainBinding.inputCelular.setVisibility(View.VISIBLE);
            else
                activityMainBinding.inputCelular.setVisibility(View.GONE);
        });

        activityMainBinding.spinnerFormacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                    activityMainBinding.inputAnoConclusao.setVisibility(View.VISIBLE);

                    activityMainBinding.inputInstituicao.setVisibility(View.GONE);
                    activityMainBinding.inputPosGraduacaoTitulo.setVisibility(View.GONE);
                    activityMainBinding.inputOrientador.setVisibility(View.GONE);
                }

                if (i == 3 || i == 4 || i == 5 || i == 6) {
                    activityMainBinding.inputInstituicao.setVisibility(View.VISIBLE);

                    activityMainBinding.inputPosGraduacaoTitulo.setVisibility(View.GONE);
                    activityMainBinding.inputOrientador.setVisibility(View.GONE);
                }

                if (i == 5 || i == 6) {
                    activityMainBinding.inputPosGraduacaoTitulo.setVisibility(View.VISIBLE);
                    activityMainBinding.inputOrientador.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @NonNull
    private Candidato getCandidato() {
        String nome = activityMainBinding.inputNome.getText().toString();
        String email = activityMainBinding.inputEmail.getText().toString();
        String tipoTelefone = activityMainBinding.spinnerTipoTelefone.getSelectedItem().toString();
        String telefone = activityMainBinding.inputTelefone.getText().toString();
        String genero = activityMainBinding.radioButtonFeminino.isChecked() ? "Feminino" : "Masculino";
        String dataNasc = activityMainBinding.inputNascimento.getText().toString();
        String vagasDeInteresse = activityMainBinding.inputVagasDeInteresse.getText().toString();

        return new Candidato(nome, email, tipoTelefone, telefone, genero, dataNasc, vagasDeInteresse);
    }
}