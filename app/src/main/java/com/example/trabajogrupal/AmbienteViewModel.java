package com.example.trabajogrupal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AmbienteViewModel extends ViewModel {
    private final MutableLiveData<Ambiente> ambienteSeleccionado = new MutableLiveData<>();

    public void seleccionarAmbiente(Ambiente ambiente) {
        ambienteSeleccionado.setValue(ambiente);
    }

    public LiveData<Ambiente> getAmbienteSeleccionado() {
        return ambienteSeleccionado;
    }
}
