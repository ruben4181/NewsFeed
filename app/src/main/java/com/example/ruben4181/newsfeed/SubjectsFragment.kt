package com.example.ruben4181.newsfeed


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.ruben4181.newsfeed.adapters.SubjectsAdapter


/**
 * A simple [Fragment] subclass.
 */
class SubjectsFragment : Fragment() {
    private lateinit var subjectsListView : ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_subjects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subjectsListView = view.findViewById(R.id.subjects_listview)

        val asignaturas = ArrayList<Subject>()
        var profesores = ArrayList<String>()
        var horarios = ArrayList<Horario>()
        horarios.add(Horario("Lunes", "16:00", "18:00", "Lagos 4.7"))
        horarios.add(Horario("Miercoles", "14:00", "16:00", "Saman 2.10"))
        horarios.add(Horario("Miercoles", "14:00", "16:00", "Saman 2.10"))
        profesores.add("Fernando Carrasquilla")
        asignaturas.add(Subject("Etica", profesores, horarios))
        asignaturas.add(Subject("Analisis y Desarrollo de Algoritmos", profesores, horarios))

        val subjectsAdapter = SubjectsAdapter(view.context, asignaturas)

        subjectsListView.adapter=subjectsAdapter
    }
}
