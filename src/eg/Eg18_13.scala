package eg

import scala.collection.mutable.ArrayBuffer

object Eg18_13 {
	import ButtonModule._
	def main(args: Array[String]): Unit = {
		val btn = new Button

		btn addListener new ClickListener {
			override def occurred(e: ButtonEvent) {
				println("e.name = " + e.name)
			}
		}
		btn addListener (new DragListener {
			override def occurred(e: ButtonEvent) {
				println("e.name = " + e.name)
			}
		})
		btn.click
		btn.drag
	}

	trait ListenerSupport {
		type S <: Source
		type E <: Event
		type L <: Listener

		trait Event {
			var source: S = _
			var name: String = _
		}

		trait Listener {
			def occurred(e: E): Unit
		}

		trait Source {
			this: S =>
			private val listeners = new ArrayBuffer[L]
			def addListener(l: L) { listeners += l }
			def removeListener(l: L) { listeners -= l }
			def fireEvent(e: E) {
				e.source = this; for (l <- listeners)  l.occurred(e) 
			}
		}

	}
	object ButtonModule extends ListenerSupport {
		type S = Button
		type E = ButtonEvent
		type L = ButtonListener

		class ButtonEvent extends Event

		class ClickEvent extends ButtonEvent {
			name = "click"
		}
		class DragEvent extends ButtonEvent {
			name = "drag"
		}
		class DropEvent extends ButtonEvent {
			name = "drop"
		}

		trait ButtonListener extends Listener

		trait ClickListener extends ButtonListener {
		}
		trait DragListener extends ButtonListener{
		}
		trait DropListener extends ButtonListener {
		}

		class Button extends Source {
			def click() {
				fireEvent(new ClickEvent)
			}

			def drag() {
				fireEvent(new DragEvent)
			}

			def drop() {
				fireEvent(new DropEvent)
			}
		}
	}
}

object Old {
	trait Listener[S, E <: Event[S]] {
		def occurred(e: E): Unit
	}

	trait Source[S, E <: Event[S], L <: Listener[S, E]] {
		this: S =>
		private val listeners = new ArrayBuffer[L]
		def addListener(l: L) { listeners += l }
		def removeListener(l: L) { listeners -= l }
		def fireEvent(e: E) { for (l <- listeners) l.occurred(e) }
	}

	trait Event[S] {
		var source: S = _
	}

}