// RENDER_DIAGNOSTICS_FULL_TEXT
class Foo<T>

class Bar<T> {
    fun <S : T> takeFoo(foo: Foo<in S>) {}
}

fun <K : <!FINAL_UPPER_BOUND!>Int<!>> main() {
    val foo = Foo<K>()
    Bar<String>().<!INFERRED_TYPE_VARIABLE_INTO_EMPTY_INTERSECTION_ERROR!>takeFoo<!>(foo) // error in 1.3.72, no error in 1.4.31
}
