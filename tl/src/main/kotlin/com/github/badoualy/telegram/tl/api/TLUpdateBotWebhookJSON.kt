package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateBotWebhookJSON#8317c0c3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotWebhookJSON() : TLAbsUpdate() {
    var data: TLDataJSON = TLDataJSON()

    private val _constructor: String = "updateBotWebhookJSON#8317c0c3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(data: TLDataJSON) : this() {
        this.data = data
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(data)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        data = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += data.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotWebhookJSON) return false
        if (other === this) return true

        return data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8317c0c3.toInt()
    }
}