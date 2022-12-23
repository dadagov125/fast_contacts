package com.github.s0nerik.fast_contacts

data class Contact(
        val id: String,
        val phones: List<ContactPhone> = emptyList(),
        val emails: List<ContactEmail> = emptyList(),
        val structuredName: StructuredName? = null,
        val organization: Organization? = null
) {
    fun asMap() = mapOf(
            "id" to id,
            "phones" to phones.map{ phone -> phone.asMap() },
            "emails" to emails.map{ email -> email.asMap() },
            "structuredName" to structuredName?.asMap(),
            "organization" to organization?.asMap(),
    )

    fun mergeWith(other: Contact) = Contact(
            id = id,
            phones = phones + other.phones,
            emails = emails + other.emails,
            structuredName = structuredName ?: other.structuredName,
            organization = organization ?: other.organization
    )
}

data class ContactPhone(
        val number: String,
        val label: String
) {
   fun asMap() = mapOf(
        "number" to number,
        "label" to label
        )
}

data class ContactEmail(
        val address: String,
        val label: String
) {
    fun asMap() = mapOf(
        "address" to address,
        "label" to label
    )
}

data class StructuredName(
        val displayName: String,
        val namePrefix: String,
        val givenName: String,
        val middleName: String,
        val familyName: String,
        val nameSuffix: String
) {
    fun asMap() = mapOf(
            "displayName" to displayName,
            "namePrefix" to namePrefix,
            "givenName" to givenName,
            "middleName" to middleName,
            "familyName" to familyName,
            "nameSuffix" to nameSuffix
    )
}

data class Organization(
        val company: String,
        val department: String,
        val jobDescription: String,
) {
        fun asMap() = mapOf(
                "company" to company,
                "department" to department,
                "jobDescription" to jobDescription,
        )
}
